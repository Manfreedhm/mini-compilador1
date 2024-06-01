
package codigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;


public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
    }
    
     private void analizarLexico() throws IOException{
        int cont = 1;
        
        String expr = (String) txtResultado.getText();
        Lexer lexer = new Lexer(new StringReader(expr));
        String resultado = "LINEA " + cont + "\t\tSIMBOLO\n";
        while (true) {
            Tokens token = lexer.yylex();
            if (token == null) {
                txtAnalizarLex.setText(resultado);
                return;
            }
            switch (token) {
                case linea:
                    cont++;
                    resultado += "LINEA " + cont + "\n";
                    break;
                case include:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + " <include indica linea import>\n";
                    break;
                case llaveApertura:
                    resultado += "  <Llave apertura>\t" + lexer.lexeme + "\n";
                    break;
                case llaveCierre:
                    resultado += "  <Llave llaveCierre>\t" + lexer.lexeme + "\n";
                    break;
                case signoMenorQue:
                    resultado += "  <Signo menor que>\t" + lexer.lexeme + "\n";
                    break;
                case signoMayorQue:
                    resultado += "  <Signo mayor que>\t" + lexer.lexeme + "\n";
                    break;
                case signoDosPuntos:
                    resultado += "  <Signo dos puntos>\t" + lexer.lexeme + "\n";
                    break;
                case signoAlmohoadilla:
                    resultado += "  <Signo almohadilla>\t" + lexer.lexeme + "\n";
                    break;
                case signoComa:
                    resultado += "  <Signo coma>\t" + lexer.lexeme + "\n";
                    break;
                case signoMas:
                    resultado += "  <Signo mas>\t" + lexer.lexeme + "\n";
                    break;
                case signoMenos:
                    resultado += "  <Signo menos>\t" + lexer.lexeme + "\n";
                    break;
                case signoMultiplicacion:
                    resultado += "  <Signo multiplicacion>\t" + lexer.lexeme + "\n";
                    break;
                case signoSlash:
                    resultado += "  <Signo slash>\t" + lexer.lexeme + "\n";
                    break;
                case parentesisApertura:
                    resultado += "  <Signo parentesis de apertura>\t" + lexer.lexeme + "\n";
                    break;
                case parentesisCierre:
                    resultado += "  <Signo parentesis de cierre>\t" + lexer.lexeme + "\n";
                    break;
                case signoPunto:
                    resultado += "  <Signo de punto>\t" + lexer.lexeme + "\n";
                    break;
                case signoOr:
                    resultado += "  <Signo OR>\t" + lexer.lexeme + "\n";
                    break;
                case RETURN:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + " <RETURN indica linea de resultado>\n";
                    break;
                case using:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <using indica inicio de espacio de nombres>\n";
                    break;
                case namespace:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <namespace indica declaración de espacio de nombres>\n";
                    break;
                case classT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <classT indica declaración de clase>\n";
                    break;
                case publicT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <publicT indica acceso público>\n";
                    break;
                case doubleT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <doubleT indica tipo de dato double>\n";
                    break;
                case charT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <charT indica tipo de dato char>\n";
                    break;
                    case DAY:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <DAY>\n";
                    break;
                case switchT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <switchT indica inicio de estructura de control switch>\n";
                    break;
                case caseT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <caseT indica caso en estructura de control switch>\n";
                    break;
                case returnT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <returnT indica retorno de función>\n";
                    break;
                case defaultT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <defaultT indica caso por defecto en estructura de control switch>\n";
                    break;
                case endlT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <endlT indica fin de línea>\n";
                    break;
                case pragmaT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <pragmaT indica directiva de compilador>\n";
                    break;
                case onceT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <onceT indica inclusión única de archivos de cabecera>\n";
                    break;
                case whileT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <whileT indica bucle while>\n";
                    break;
                case continueT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <continueT indica continuación de bucle>\n";
                    break;
                case ifT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <ifT indica estructura de control if>\n";
                    break;
                case elseT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <elseT indica estructura de control else>\n";
                    break;
                case trueT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <trueT indica valor booleano verdadero>\n";
                    break;
                case falseT:
                    resultado += "<Palabra Reservada>\t" + lexer.lexeme + " <falseT indica valor booleano falso>\n";
                    break;
                case INT:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + " <VARIABLE INT>\n";
                    break;
                case SHORT:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE SHORT>\n";
                    break;
                case BYTE:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE BYTE>\n";
                    break;
                case LONG:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE LONG>\n";
                    break;
                case FLOAT:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE FLOAT>\n";
                    break;
                case DOUBLE:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE DOUBLE>\n";
                    break;
                case BOOLEAN:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE BOOLEAN>\n";
                    break;
                case CHAR:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE CHAR>\n";
                    break;
                case VERDADERO:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE VERDADERO>\n";
                    break;
                case FALSO:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE FALSO>\n";
                    break;
                    case igual:
                    resultado += "  <Signo igual >\t" + lexer.lexeme + "\n";
                    break;
                case STRING:
                    resultado += "  <Palabra Reservada>\t" + lexer.lexeme + "<VARIABLE STRING>\n";
                    break;
              case coma:
                    resultado += "  <coma>\t\t" + lexer.lexeme + "<coma>\n";
                    break;
              case asterisco:
                    resultado += "  <asterisco>\t\t" + lexer.lexeme + " <separador>\n";
                    break;
                case puntoComa:
                    resultado += "  <Punto y coma>\t" + lexer.lexeme + "\n";
                    break;
                case Identificador:
                    resultado += "  <Identificador>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo no definido, ERROR LEXICO>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArchivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalizarLex = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalizarSin = new javax.swing.JTextArea();
        btnAnalizarSin = new javax.swing.JButton();
        btnLimpiarSin = new javax.swing.JButton();
        bntAnalizarLex = new javax.swing.JButton();
        btnLimpiarLex = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 204, 255));

        btnArchivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnArchivo.setText("Abrir Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        txtResultado.setText("ENTRADA DE CODIGO");
        jScrollPane1.setViewportView(txtResultado);

        txtAnalizarLex.setEditable(false);
        txtAnalizarLex.setColumns(20);
        txtAnalizarLex.setRows(5);
        jScrollPane2.setViewportView(txtAnalizarLex);

        txtAnalizarSin.setEditable(false);
        txtAnalizarSin.setColumns(20);
        txtAnalizarSin.setRows(5);
        jScrollPane3.setViewportView(txtAnalizarSin);

        btnAnalizarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalizarSin.setText("Analizar Sintactico");
        btnAnalizarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarSinActionPerformed(evt);
            }
        });

        btnLimpiarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarSin.setText("Limpiar");
        btnLimpiarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarSinActionPerformed(evt);
            }
        });

        bntAnalizarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        bntAnalizarLex.setText("Analizador Lexico");
        bntAnalizarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAnalizarLexActionPerformed(evt);
            }
        });

        btnLimpiarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimpiarLex.setText("Limpiar");
        btnLimpiarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnalizarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiarSin, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(bntAnalizarLex, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiarLex, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArchivo)
                    .addComponent(bntAnalizarLex)
                    .addComponent(btnLimpiarLex))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAnalizarSin)
                    .addComponent(btnLimpiarSin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        // TODO add your handling code here:
       JFileChooser chooser = new JFileChooser();
       chooser.showOpenDialog(null);
       File archivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST= new String(Files.readAllBytes(archivo.toPath()));
            txtResultado.setText(ST);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void btnAnalizarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarSinActionPerformed
        String ST = txtResultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        try {
            s.parse();
            txtAnalizarSin.setText("Analisis realizado correctamente");
            txtAnalizarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalizarSin.setText("Error de sintaxis. Linea: " + (sym.right + 1) + " Columna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalizarSin.setForeground(Color.red);
        }
    }//GEN-LAST:event_btnAnalizarSinActionPerformed

    private void btnLimpiarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarSinActionPerformed
        txtAnalizarSin.setText(null);
    }//GEN-LAST:event_btnLimpiarSinActionPerformed

    private void bntAnalizarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAnalizarLexActionPerformed
        try {
            analizarLexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bntAnalizarLexActionPerformed

    private void btnLimpiarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarLexActionPerformed
        txtAnalizarLex.setText(null);
    }//GEN-LAST:event_btnLimpiarLexActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAnalizarLex;
    private javax.swing.JButton btnAnalizarSin;
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnLimpiarLex;
    private javax.swing.JButton btnLimpiarSin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalizarLex;
    private javax.swing.JTextArea txtAnalizarSin;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
