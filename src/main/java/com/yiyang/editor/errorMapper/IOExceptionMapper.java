package com.yiyang.editor.errorMapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import java.io.IOException;

public class IOExceptionMapper implements ExceptionMapper<IOException> {

   public Response toResponse(IOException ex) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR).
         entity(ex.getMessage()).type("text/plain").build();
   }
}
