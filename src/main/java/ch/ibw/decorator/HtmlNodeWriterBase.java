package ch.ibw.decorator;

import ch.ibw.HtmlNode;

abstract public class HtmlNodeWriterBase {

  public String write(HtmlNode node){
    return writeStartTag(node)
            .append(writeChildren(node))
            .append(writeEndTag(node))
            .toString();
  }

  abstract protected HtmlNodeWriterBase getWriter();

  protected StringBuilder writeChildren(HtmlNode node){
    StringBuilder children = new StringBuilder();
    node.children.forEach((child) -> children.append(getWriter().write((HtmlNode) child)));
    return children;
  }

  abstract protected StringBuilder writeStartTag(HtmlNode node);

  abstract protected StringBuilder writeEndTag(HtmlNode node);

  abstract protected StringBuilder writeAttributes(HtmlNode node);
}
