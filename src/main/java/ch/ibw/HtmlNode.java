package ch.ibw;

import ch.ibw.visitor.CompositeVisitor;

public class HtmlNode extends AttributedCompositeNode {
  public String name;

  private HtmlNode(String name) {
    super();
    this.name = name;
  }

  public void accept(CompositeVisitor visitor) {
    visitor.visit(this);
  }

  @Override
  public HtmlNode setAttribute(String key, String value) {
    super.setAttribute(key, value);
    return this;
  }

  public static HtmlNode create(String name){
    return new HtmlNode(name);
  }
}
// This comment will trigger a jenkins build
