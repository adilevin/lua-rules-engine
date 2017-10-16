package com.github.adilevin;

import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class CodeGenerator {

  private Configuration cfg;
  private Template template;

  public CodeGenerator(String templateName) throws IOException {
    cfg = createFreeMarkerConfig();
    template = cfg.getTemplate(templateName);
  }

  private Configuration createFreeMarkerConfig() {
    cfg = new Configuration(Configuration.VERSION_2_3_25);
    cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(), "freemarker-templates");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    return cfg;
  }

  public String generateLUA(IntermediateModel model) throws IOException, TemplateException {
    Writer out = new StringWriter(0);
    template.process(model, out);
    return out.toString();
  }

}
