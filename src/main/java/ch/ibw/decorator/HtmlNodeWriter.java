package ch.ibw.decorator;

import ch.ibw.HtmlNode;

public class HtmlNodeWriter extends HtmlNodeWriterBase {
  public static final String TAG_OPEN = "<";
  public static final String TAG_CLOSE = ">";
  public static final String CLOSING_TAG_OPEN = "</";
  private static final String BLANK = " ";

  private HtmlNodeWriter(){}

  public static HtmlNodeWriter create(){
    return new HtmlNodeWriter();
  }

  protected HtmlNodeWriter getWriter(){
    return HtmlNodeWriter.create();
  }

  protected StringBuilder writeStartTag(HtmlNode node){
    return new StringBuilder()
            .append(TAG_OPEN)
            .append(node.name)
            .append(writeAttributes(node))
            .append(TAG_CLOSE);
  }

  protected StringBuilder writeEndTag(HtmlNode node){
    return new StringBuilder()
            .append(CLOSING_TAG_OPEN)
            .append(node.name)
            .append(TAG_CLOSE);
  }

  protected StringBuilder writeAttributes(HtmlNode node) {
    StringBuilder attributes = new StringBuilder();
    node.attributes.forEach((key, value) -> attributes
            .append(BLANK)
            .append(key)
            .append("='")
            .append(value)
            .append("'"));
    return attributes;
  }
}
