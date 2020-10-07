package com.yiyang.editor.resource;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

public class LoadFileResource {

   @POST
   @Path("/load")
   public Response loadFile(@FormParam("editor") String template) {
      String loadDirectory = "/opt/e2e/test/e2e/sampleDashboards/tests/";

      File testSpecDirectory = new File(loadDirectory);



      return Response.status(200).entity(null).build();
   }

   @POST
   @Path("/populate")
   @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
   public Response populateList(@FormParam("editor") String template) {

      String uploadedFileLocation = "/opt/e2e_protractor/test/e2e/sampleDashboards/tests/testTemplate.spec.js";

      String output = "File uploaded to : " + uploadedFileLocation;

      return Response.status(200).entity(output).build();
   }
}
