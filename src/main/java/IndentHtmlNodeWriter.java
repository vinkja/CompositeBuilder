import java.util.Collections;

public class IndentHtmlNodeWriter extends HtmlNodeWriter {
  public static final String BLANK = " ";
  private Integer level = 0;

  public IndentHtmlNodeWriter(Integer level) {
    this.level = level;
  }

  public static IndentHtmlNodeWriter create(Integer level){
    return new IndentHtmlNodeWriter(level);
  }

  @Override
  protected HtmlNodeWriter getWriter() {
    return IndentHtmlNodeWriter.create(level);
  }

  @Override
  protected StringBuilder writeChildren(AttributedCompositeNode node) {
    level += 1;
    return super.writeChildren(node);
  }

  @Override
  protected StringBuilder writeStartTag(AttributedCompositeNode node) {
    StringBuilder startTag = super.writeStartTag(node);
    if(level == 0){
      return startTag;
    }
    return new StringBuilder().append("\n").append(generateIndentSpaces(level)).append(startTag);
  }

  @Override
  protected StringBuilder writeEndTag(AttributedCompositeNode node) {
    if(node.isLastChild()){
      return super.writeEndTag(node).append("\n");
    }
    return super.writeEndTag(node);
  }

  private String generateIndentSpaces(Integer level){
    return String.join("", Collections.nCopies(level, BLANK));
  }
}
