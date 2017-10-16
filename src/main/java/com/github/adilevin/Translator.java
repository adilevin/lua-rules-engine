package com.github.adilevin;

import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by alevin on 10/15/2017.
 */
public class Translator {

  private Configuration cfg;
  private Template tmpl;

  public Translator() throws IOException {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);
    cfg.setClassLoaderForTemplateLoading(getClass().getClassLoader(),"freemarker-templates");
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(false);
    tmpl = cfg.getTemplate("conditional.ftlh");
  }


  public String generateLUA(IntermediateModel model) throws IOException, TemplateException {

    Writer out = new StringWriter(128);
    for (IntermediateModel.Conditional cond : model.conditionals) {
      Map<String, Object> root = new HashMap<>();
      root.put("predicate", cond.getPredicate());
      root.put("action", cond.getAction());
      tmpl.process(root, out);
    }
    return out.toString();
  }

}
