public class HtmlNodeFactory {

  public static HtmlNode createA(String href){
    return HtmlNode.create("a").setAttribute("href", href);
  }

  public static HtmlNode createSpan(){
    return HtmlNode.create("span");
  }
}
