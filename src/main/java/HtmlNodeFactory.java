public class HtmlNodeFactory {

  public static AttributedCompositeNode createA(String href){
    return AttributedCompositeNode.create("a").setAttribute("href", href);
  }
}
