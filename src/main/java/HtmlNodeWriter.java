public class HtmlNodeWriter extends HtmlNodeWriterBase {
  private static final String TAG_OPEN = "<";
  private static final String TAG_CLOSE = ">";
  private static final String CLOSING_TAG_OPEN = "</";
  private static final String BLANK = " ";

  private HtmlNodeWriter(){}

  public static HtmlNodeWriter create(){
    return new HtmlNodeWriter();
  }

  protected HtmlNodeWriter getWriter(){
    return HtmlNodeWriter.create();
  }

  protected StringBuilder writeStartTag(AttributedCompositeNode node){
    return new StringBuilder()
            .append(TAG_OPEN)
            .append(node.name)
            .append(writeAttributes(node))
            .append(TAG_CLOSE);
  }

  protected StringBuilder writeEndTag(AttributedCompositeNode node){
    return new StringBuilder()
            .append(CLOSING_TAG_OPEN)
            .append(node.name)
            .append(TAG_CLOSE);
  }

  protected StringBuilder writeAttributes(AttributedCompositeNode node) {
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
