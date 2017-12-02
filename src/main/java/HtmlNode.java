public class HtmlNode extends AttributedCompositeNode {
  public String name;

  private HtmlNode(String name) {
    super();
    this.name = name;
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
