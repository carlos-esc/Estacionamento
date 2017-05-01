package mascarasentrada;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class EntradaHora extends PlainDocument {

    int tamanhoMaximo = 5;

    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        String texto = getText(0, getLength()) + str.replaceAll("[^0-9]", "");
        if (texto.length() <= tamanhoMaximo) {
            remove(0, getLength());
            StringBuffer textoBuffer = new StringBuffer(texto.replaceAll(":", ""));
            if (texto.length() > 2) {
                textoBuffer.insert(textoBuffer.length() - 2, ":");
                super.insertString(0, textoBuffer.toString(), a);
            } else {
                super.insertString(0, textoBuffer.toString(), a);
            }
        }
    }
}
