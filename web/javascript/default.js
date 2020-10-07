$(document).ready(function() {
   $('#submitForm').ajaxForm({
      beforeSubmit: setFormData,
      success: function () {
         alert("Success!");
      },
      error: function (error) {
         alert(error);
      }
   });

   let editor = CodeMirror.fromTextArea(document.getElementById("code-editor"), {
      lineNumbers: true,
      mode: "javascript",
      gutters: ["CodeMirror-lint-markers"],
      lint: {esversion: 6},
      theme: "neat",
      styleActiveLine: true,
      matchBrackets: true
   });

   function setFormData(formData, form, options) {
      formData.pop();
      formData.push({name: 'editor', value: editor.getValue()});
   }


   //select theme does not work
   let input = document.getElementById("themeSelect");

   let choice = (location.hash && location.hash.slice(1)) ||
      (document.location.search &&
         decodeURIComponent(document.location.search.slice(1)));

   if(choice) {
      input.value = choice;
      editor.setOption("theme", choice);
   }

   $('#themeSelect').change(function() {
      let newTheme = $("#themeSelect option:selected").text();
      editor.setOption("theme", newTheme);
      location.hash = "#" + newTheme;
   });

   CodeMirror.on(window, "hashchange", function () {
      let theme = location.hash.slice(1);
      if(theme) {
         input.value = theme;
         changeExampleLink();
      }
   });

   function changeExampleLink() {
      let exampleLink = document.getElementById("exampleButton");
      let hashIndex = exampleLink.href.indexOf('#');

      if(hashIndex > 0) {
         exampleLink.href = exampleLink.href.substring(hashIndex);
      }

      exampleLink.href = exampleLink.href + location.hash;
   }
});






