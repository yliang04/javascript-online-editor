package com.yiyang.editor;

import com.yiyang.editor.resource.*;
import com.yiyang.editor.resource.DownloadResource;
import com.yiyang.editor.resource.HelloWorldResource;
import com.yiyang.editor.resource.SaveTemplateResource;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/*
   JS Editor App
 */
public class EditorApp extends Application {
   @Override
   public Set<Class<?>> getClasses() {
      final Set<Class<?>> classes = new HashSet<Class<?>>();
      // register resources and features
      classes.add(MultiPartFeature.class);
      //classes.add(MultiPartResource.class);
      classes.add(HelloWorldResource.class);
      classes.add(SaveTemplateResource.class);
      classes.add(DownloadResource.class);
      return classes;
   }
}
