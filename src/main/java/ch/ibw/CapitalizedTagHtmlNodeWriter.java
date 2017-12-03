package ch.ibw;

import ch.ibw.decorator.HtmlNodeWriter;
import ch.ibw.decorator.HtmlNodeWriterBase;
import ch.ibw.decorator.HtmlNodeWriterDecorator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalizedTagHtmlNodeWriter extends HtmlNodeWriterDecorator {

  private CapitalizedTagHtmlNodeWriter(HtmlNodeWriterBase nested) {
    super(nested);
  }

  public static CapitalizedTagHtmlNodeWriter create(HtmlNodeWriterBase nested){
    return new CapitalizedTagHtmlNodeWriter(nested);
  }

  public static CapitalizedTagHtmlNodeWriter create(){
    return new CapitalizedTagHtmlNodeWriter(HtmlNodeWriter.create());
  }

  @Override
  protected HtmlNodeWriterBase getWriter() {
    return CapitalizedTagHtmlNodeWriter.create(nested);
  }

  @Override
  protected StringBuilder writeStartTag(HtmlNode node) {
    String startTag = super.writeStartTag(node).toString();
    // Regex: "<" followed by at least one none white space, followed by either blank or ">"
    Matcher matcher = Pattern.compile("<[^\\s]+( |>)").matcher(startTag);
    StringBuffer result = new StringBuffer();
    while (matcher.find()) {
      matcher.appendReplacement(result, matcher.group().toUpperCase());
    }
    matcher.appendTail(result);

    return new StringBuilder(result);
  }

  @Override
  protected StringBuilder writeEndTag(HtmlNode node) {
    String endTag = super.writeEndTag(node).toString();
    return new StringBuilder(endTag.toUpperCase());
  }
}
