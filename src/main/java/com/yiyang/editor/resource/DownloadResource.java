package com.yiyang.editor.resource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

@Path("/download")
public class DownloadResource {

   @GET
   @Path("/images")
   public Response downloadPdfFile()
   {
      StreamingOutput fileStream =  (java.io.OutputStream output) ->
      {
         try
         {
            java.nio.file.Path path = Paths.get(zipDirectory + zipFile);
            byte[] data = Files.readAllBytes(path);
            output.write(data);
            output.flush();
         }
         catch (Exception e)
         {
            throw new IOException("Image zip file not found. Please contact system admin");
         }
      };

      return Response
         .ok(fileStream, MediaType.APPLICATION_OCTET_STREAM)
         .header("content-disposition","attachment; filename = " + zipFile)
         .build();
   }

   private static String zipDirectory= "/opt/e2e/test/";
   private static String zipFile= "screenCaptures.zip";
}
