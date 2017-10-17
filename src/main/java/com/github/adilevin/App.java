package com.github.adilevin;

import freemarker.template.TemplateException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

public class App {
  private static final String INPUT_FILE_NAME = "/dsl-scripts/1.rules";
  private static final String OUTPUT_FILE_NAME = "rules.lua";

  public static void main(String[] args) throws IOException, TemplateException {
    IntermediateModel intermediateModel = parseDSLScript(INPUT_FILE_NAME);
    String luaCode = generateLUACode(intermediateModel);
    writeLUAFile(luaCode, OUTPUT_FILE_NAME);
    System.out.println("Done.");
  }

  private static IntermediateModel parseDSLScript(String inputFileName) throws IOException {
    System.out.println("Parsing " + inputFileName);
    InputStream in = App.class.getResourceAsStream(inputFileName);
    return DSLParser.parseDSLScript(in);
  }

  private static void writeLUAFile(String luaCode, String filename) throws FileNotFoundException {
    System.out.println("Writing " + filename);
    PrintWriter writer = new PrintWriter(filename);
    writer.print(luaCode);
    writer.close();
  }

  private static String generateLUACode(IntermediateModel intermediateModel) throws IOException, TemplateException {
    System.out.println("Generating LUA Code");
    CodeGenerator codeGenerator = new CodeGenerator("lua-output.ftlh");
    return codeGenerator.generateLUA(intermediateModel);
  }

}
