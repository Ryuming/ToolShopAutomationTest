package ToolShopUI.component;

public class EmailFormat {
    int numUpperCaseChar;
    int numLowerCaseChar;
    int numNumberChar;

    int beforeDotChar;
    int afterDotChar;

    public EmailFormat(int numUpperCaseChar, int numLowerCaseChar, int numNumberChar, int beforeDotChar, int afterDotChar) {
        this.numUpperCaseChar = numUpperCaseChar;
        this.numLowerCaseChar = numLowerCaseChar;
        this.numNumberChar = numNumberChar;
        this.beforeDotChar = beforeDotChar;
        this.afterDotChar = afterDotChar;
    }

    public EmailFormat(EmailFormat emailFormat) {
        this.numUpperCaseChar = emailFormat.numUpperCaseChar;
        this.numLowerCaseChar = emailFormat.numLowerCaseChar;
        this.numNumberChar = emailFormat.numNumberChar;
        this.beforeDotChar = emailFormat.beforeDotChar;
        this.afterDotChar = emailFormat.afterDotChar;
    }

    public int getNumUpperCaseChar() {
        return numUpperCaseChar;
    }
    public int getNumLowerCaseChar() {
        return numLowerCaseChar;
    }
    public int getNumNumberChar() {
        return numNumberChar;
    }
    public int getBeforeDotChar() {
        return beforeDotChar;
    }
    public int getAfterDotChar() {
        return afterDotChar;
    }

    public void setNumUpperCaseChar(int numUpperCaseChar) {
        this.numUpperCaseChar = numUpperCaseChar;
    }
    public void setNumLowerCaseChar(int numLowerCaseChar) {
        this.numLowerCaseChar = numLowerCaseChar;
    }
    public void setNumNumberChar(int numNumberChar) {
        this.numNumberChar = numNumberChar;
    }
    public void setBeforeDotChar(int beforeDotChar) {
        this.beforeDotChar = beforeDotChar;
    }
    public void setAfterDotChar(int afterDotChar) {
        this.afterDotChar = afterDotChar;
    }

}
