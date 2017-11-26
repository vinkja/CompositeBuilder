import java.util.Collections;

public class IndentHtmlNodeWriter extends HtmlNodeWriterDecorator {
  public static final String BLANK = " ";
  private Integer level = 0;

  private IndentHtmlNodeWriter(Integer level, HtmlNodeWriterBase nested) {
    super(nested);
    this.level = level;
  }

  public static IndentHtmlNodeWriter create(Integer level, HtmlNodeWriterBase nested){
    return new IndentHtmlNodeWriter(level, nested);
  }

  @Override
  protected HtmlNodeWriterBase getWriter() {
    return IndentHtmlNodeWriter.create(level, nested);
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
