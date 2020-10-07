package com.yiyang.editor.resource;

import java.io.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/file")
public class SaveTemplateResource {

   @POST
   @Path("/save")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response saveFile(@FormParam("editor") String template) throws IOException{

      String uploadDirectory = "/opt/e2e/test/e2e/sampleDashboards/tests/testTemplate.spec.js";

      // save it
      writeToFile(template, uploadDirectory);

      return Response.status(200).entity("File uploaded to : " + uploadDirectory).build();
   }

   /**
    * Save uploaded file to new location
    * @param text testScript content
    * @param uploadDirectory upload directory
    */
   private void writeToFile(String text, String uploadDirectory) throws IOException{
      File template = new File(uploadDirectory);

      if(!template.exists()) {
         throw new IOException(uploadDirectory + "does not exist");
      }

      try(PrintWriter writer = new PrintWriter(template)) {
         writer.write(text);
      } catch (IOException ex) {
         System.out.println("************failed to write");
         ex.printStackTrace();
         throw new IOException("Error saving script to " + uploadDirectory, ex);
      }
   }
}