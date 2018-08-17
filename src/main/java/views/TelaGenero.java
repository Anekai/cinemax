
package views;

import configuration.SpringConfig;
import entities.Genero;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import services.GeneroService;
import services.ProdutoService;
import types.SimNaoType;
import types.SituacaoType;

public class TelaGenero extends javax.swing.JDialog {

    private Genero entitySearch;
    private Genero entity;
    
    public TelaGenero(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        entitySearch = new Genero();
        
        comboSearchAtivo.removeAllItems();
        comboSearchAtivo.addItem("");
        
        for ( SimNaoType simNao : SimNaoType.values() ) {
            comboSearchAtivo.addItem(simNao.getValue());
        }
               
        loadTiposGeneros();        
    }
    
    private void load() {
        GeneroService service = SpringConfig.context.getBean(GeneroService.class);
        
        if (!fieldSearchId.getText().equals("")) {
            entitySearch.setId(Integer.valueOf(fieldSearchId.getText()));
        }
        
        if (!fieldSearchNome.getText().equals("")) {
            entitySearch.setNome(fieldSearchNome.getText());
        }
        
        if (comboSearchAtivo.getSelectedIndex() != 0) {
            entitySearch.setAtivo(Arrays.asList(SimNaoType.values()).get(comboSearchAtivo.getSelectedIndex()-1));
        }   
        
        populateTable(service.find(entitySearch));
        
        entitySearch = new Genero();
    }
    
    private void loadTiposGeneros() {

    }
    
    private void populateTable(List<Genero> list) {
        DefaultTableModel model = (DefaultTableModel) tableGenero.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        
        for ( Genero genero : list ) {
            rowData[0] = genero.getId();
            rowData[1] = genero.getNome();
            rowData[2] = genero.getAtivo().getValue();

            model.addRow(rowData);
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

        dialogInsert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        fieldInsertNome = new javax.swing.JTextField();
        buttonInsertSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fieldInsertDescricao = new javax.swing.JTextField();
        dialogUpdate = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldUpdateNome = new javax.swing.JTextField();
        fieldUpdateId = new javax.swing.JTextField();
        buttonUpdateSalvar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fieldUpdateDescricao = new javax.swing.JTextField();
        comboUpdateAtivo = new javax.swing.JComboBox<>();
        buttonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGenero = new javax.swing.JTable();
        fieldSearchId = new javax.swing.JTextField();
        fieldSearchNome = new javax.swing.JTextField();
        buttonPesquisar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        comboSearchAtivo = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        dialogInsert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInsert.setTitle("Cadastrar Produto");
        dialogInsert.setModal(true);
        dialogInsert.setResizable(false);
        dialogInsert.setSize(new java.awt.Dimension(360, 200));

        jLabel6.setText("*Nome:");

        buttonInsertSalvar.setText("Salvar");
        buttonInsertSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonInsertSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("*Descricao");

        javax.swing.GroupLayout dialogInsertLayout = new javax.swing.GroupLayout(dialogInsert.getContentPane());
        dialogInsert.getContentPane().setLayout(dialogInsertLayout);
        dialogInsertLayout.setHorizontalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogInsertLayout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(56, 56, 56)
                                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldInsertDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonInsertSalvar))
                        .addGap(0, 48, Short.MAX_VALUE))))
        );
        dialogInsertLayout.setVerticalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(fieldInsertDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonInsertSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogUpdate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogUpdate.setTitle("Atualizar Produto");
        dialogUpdate.setModal(true);
        dialogUpdate.setResizable(false);
        dialogUpdate.setSize(new java.awt.Dimension(300, 300));

        jLabel4.setText("*Nome:");

        jLabel5.setText("ID:");

        fieldUpdateId.setEditable(false);

        buttonUpdateSalvar.setText("Salvar");
        buttonUpdateSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateSalvarActionPerformed(evt);
            }
        });

        jLabel10.setText("*Descricao:");

        jLabel12.setText("Situação:");

        javax.swing.GroupLayout dialogUpdateLayout = new javax.swing.GroupLayout(dialogUpdate.getContentPane());
        dialogUpdate.getContentPane().setLayout(dialogUpdateLayout);
        dialogUpdateLayout.setHorizontalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(45, 45, 45)
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboUpdateAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldUpdateDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(buttonUpdateSalvar))
                        .addGap(0, 16, Short.MAX_VALUE))
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        dialogUpdateLayout.setVerticalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fieldUpdateDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboUpdateAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Generos");

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        tableGenero.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Situação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableGenero.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableGenero);
        if (tableGenero.getColumnModel().getColumnCount() > 0) {
            tableGenero.getColumnModel().getColumn(0).setMinWidth(50);
            tableGenero.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableGenero.getColumnModel().getColumn(0).setMaxWidth(50);
            tableGenero.getColumnModel().getColumn(1).setResizable(false);
            tableGenero.getColumnModel().getColumn(2).setMinWidth(80);
            tableGenero.getColumnModel().getColumn(2).setPreferredWidth(80);
            tableGenero.getColumnModel().getColumn(2).setMaxWidth(80);
        }

        buttonPesquisar.setText("Pesquisar");
        buttonPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPesquisarActionPerformed(evt);
            }
        });

        buttonNovo.setText("Novo");
        buttonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNovoActionPerformed(evt);
            }
        });

        jLabel3.setText("Ativo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(buttonPesquisar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonNovo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonEditar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboSearchAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboSearchAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Genero();
                entity.setId((Integer) tableGenero.getValueAt(tableGenero.getSelectedRow(), 0));

                entity = SpringConfig.context.getBean(GeneroService.class).find(entity).get(0);

                fieldUpdateId.setText(String.valueOf(entity.getId()));
                fieldUpdateNome.setText(entity.getNome());
                fieldUpdateDescricao.setText(entity.getDescricao());
                
                comboUpdateAtivo.removeAllItems();
                
                for ( SimNaoType simNao : SimNaoType.values() ) {
                    comboUpdateAtivo.addItem(simNao.getValue());
                }
                
                comboUpdateAtivo.setSelectedIndex(Arrays.asList(SimNaoType.values()).indexOf(entity.getAtivo()));

                dialogUpdate.setLocationRelativeTo(null);
                dialogUpdate.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        load();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Genero();

                fieldInsertNome.setText("");
                fieldInsertDescricao.setText("");
                
                loadTiposGeneros();
                
//                comboInsertTipoProduto.removeAllItems();
                
                dialogInsert.setLocationRelativeTo(null);
                dialogInsert.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldInsertNome.getText());
                entity.setDescricao(fieldInsertDescricao.getText());
                entity.setAtivo(SimNaoType.SIM);

                GeneroService service = SpringConfig.context.getBean(GeneroService.class);

                service.insert(entity);
                
                fieldInsertNome.setText("");
                fieldInsertDescricao.setText("");
                
                dialogInsert.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonUpdateSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldUpdateNome.getText());
                entity.setDescricao(fieldUpdateDescricao.getText());
                entity.setAtivo(Arrays.asList(SimNaoType.values()).get(comboUpdateAtivo.getSelectedIndex()));

                GeneroService service = SpringConfig.context.getBean(GeneroService.class);

                service.update(entity);

                fieldUpdateNome.setText("");
                fieldUpdateDescricao.setText("");

                dialogUpdate.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonUpdateSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaGenero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaGenero dialog = new TelaGenero(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonUpdateSalvar;
    private javax.swing.JComboBox<String> comboSearchAtivo;
    private javax.swing.JComboBox<String> comboUpdateAtivo;
    private javax.swing.JDialog dialogInsert;
    private javax.swing.JDialog dialogUpdate;
    private javax.swing.JTextField fieldInsertDescricao;
    private javax.swing.JTextField fieldInsertNome;
    private javax.swing.JTextField fieldSearchId;
    private javax.swing.JTextField fieldSearchNome;
    private javax.swing.JTextField fieldUpdateDescricao;
    private javax.swing.JTextField fieldUpdateId;
    private javax.swing.JTextField fieldUpdateNome;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableGenero;
    // End of variables declaration//GEN-END:variables
}
