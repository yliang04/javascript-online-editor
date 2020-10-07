package com.yiyang.editor.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/file")
public class RunTestResource {

   @POST
   @Path("/run")
   public Response run() {
      // run command
      boolean result = this.runTest();

      return Response.status(200).entity("success").build();
   }

   // save uploaded file to new location
   private boolean runTest() {
      //Run macro on target
      ProcessBuilder pb = new ProcessBuilder("npm", "run", "test");
      pb.directory(new File("/opt/e2e_protractor/test/"));


      File outputLog = new File("/opt/e2e_protractor/test/logs/output.log");
      File erroeLog = new File("/opt/e2e_protractor/test/logs/errorMapper.log");

      boolean result = false;

      try {
         pb.redirectErrorStream(true);
         pb.redirectOutput(outputLog);
         pb.redirectError(erroeLog);

         Process process = pb.start();

         if(process.waitFor() == 0) {
            result = true;
         }
      }
      catch (IOException | IllegalArgumentException | InterruptedException e) {
         e.printStackTrace();
      }

      return result;
   }
}