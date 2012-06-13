/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package treintayplaya;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Pablo
 */
public class FixedLengthDocument extends PlainDocument{
    public int maxLength;

    public FixedLengthDocument(int maxLength) {
        this.maxLength = maxLength;
    }
    @Override
    public void insertString(int offset, String str, AttributeSet a) throws BadLocationException {
        if (getLength() + str.length() > maxLength) {
            Toolkit.getDefaultToolkit().beep();
        }else {
            super.insertString(offset, str, a);
        }
    }

    
}
