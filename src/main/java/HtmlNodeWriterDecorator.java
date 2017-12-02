public class HtmlNodeWriterDecorator extends HtmlNodeWriterBase {
  protected HtmlNodeWriterBase nested;

  public HtmlNodeWriterDecorator(HtmlNodeWriterBase nested) {
    this.nested = nested;
  }

  @Override
  protected HtmlNodeWriterBase getWriter() {
    return nested.getWriter();
  }

  @Override
  protected StringBuilder writeStartTag(HtmlNode node) {
    return nested.writeStartTag(node);
  }

  @Override
  protected StringBuilder writeEndTag(HtmlNode node) {
    return nested.writeEndTag(node);
  }

  @Override
  protected StringBuilder writeAttributes(HtmlNode node) {
    return nested.writeAttributes(node);
  }
}
