abstract public class HtmlNodeWriterBase {

  public String write(AttributedCompositeNode node){
    return writeStartTag(node)
            .append(writeChildren(node))
            .append(writeEndTag(node))
            .toString();
  }

  abstract protected HtmlNodeWriterBase getWriter();

  protected StringBuilder writeChildren(AttributedCompositeNode node){
    StringBuilder children = new StringBuilder();
    node.children.forEach((child) -> children.append(getWriter().write(child)));
    return children;
  }

  abstract protected StringBuilder writeStartTag(AttributedCompositeNode node);

  abstract protected StringBuilder writeEndTag(AttributedCompositeNode node);

  abstract protected StringBuilder writeAttributes(AttributedCompositeNode node);
}
