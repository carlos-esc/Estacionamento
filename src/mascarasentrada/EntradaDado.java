package mascarasentrada;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class EntradaDado extends PlainDocument {
    private int qtdDados;
    private String tipoDados;
        
    public EntradaDado(int maxLen, String tipoLen) {
        super();
        if(maxLen<=0)
            throw new IllegalArgumentException("Especifique a quantidade de caracteres do jTextPlacaOuPrisma!");
        qtdDados=maxLen;
        tipoDados=tipoLen;
    }

    @Override
    public void insertString(int offset,String str, AttributeSet attr) throws BadLocationException{
        if(str==null||getLength()==qtdDados)
            return;
        int totalquantia=(getLength()+str.length());
        if(totalquantia<=qtdDados) {
            super.insertString(offset, str.toUpperCase().replaceAll(tipoDados, ""), attr);
        return;
        }
        String nova = str.substring(0,getLength()-qtdDados);
        super.insertString(offset,nova, attr);  
    }             
}
