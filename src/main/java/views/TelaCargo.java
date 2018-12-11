
package views;

import configuration.SpringConfig;
import entities.AcaoTela;
import entities.Cargo;
import entities.CargoAcaoTela;
import entities.Tela;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.DefaultTableModel;

import framework.ArquivoLog;
import services.AcaoTelaService;
import services.CargoAcaoTelaService;
import services.CargoService;
import services.TelaService;
import types.SimNaoType;

public class TelaCargo extends javax.swing.JDialog {

    private Cargo entitySearch;
    private Cargo entity;
    private Tela tela;
    private List<Tela> telas;
    private List<AcaoTela> acoes;
    private List<CargoAcaoTela> permissoes;
    
    public TelaCargo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try{
            initComponents();

            this.setLocationRelativeTo(null);

            entitySearch = new Cargo();

            comboSearchAtivo.removeAllItems();
            comboSearchAtivo.addItem("");

            for ( SimNaoType simNao : SimNaoType.values() ) {
                comboSearchAtivo.addItem(simNao.getValue());
            }

        }catch(Exception e){
            new ArquivoLog(e.toString());
        }
    }
    
    private void load() {
        try{
            CargoService service = SpringConfig.context.getBean(CargoService.class);

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
        }catch(Exception e){
            new ArquivoLog(e.toString());
        }
    }
    
    private void populateTable(List<Cargo> list) {
        DefaultTableModel model = (DefaultTableModel) tableCargo.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        
        for ( Cargo cargo : list ) {
            rowData[0] = cargo.getId();
            rowData[1] = cargo.getNome();
            rowData[2] = cargo.getAtivo().getValue();

            model.addRow(rowData);
        }
    }
    
    private void populateTablePermissoes(List<CargoAcaoTela> list) {
        DefaultTableModel model = (DefaultTableModel) tablePermissoes.getModel();
        Object rowData[] = new Object[3];
        model.setRowCount(0);
        
        for ( CargoAcaoTela permissao : list ) {
            rowData[0] = permissao.getId();
            rowData[1] = permissao.getAcaoTela().getTela().getNome();
            rowData[2] = permissao.getAcaoTela().getAcao().getNome();

            model.addRow(rowData);
        }
    }
    
    private void loadPermissoes() {
        CargoAcaoTela permissaoForSearch = new CargoAcaoTela();
        
        permissaoForSearch.setCargo(entity);
        
        permissoes = SpringConfig.context.getBean(CargoAcaoTelaService.class).find(permissaoForSearch);
        populateTablePermissoes(permissoes);
    }
    
    private void loadTelas() {
        telas = SpringConfig.context.getBean(TelaService.class).find();
        
        comboUpdateTela.removeAllItems();
        comboUpdateTela.addItem("");

        for ( Tela tela : telas ) {
            comboUpdateTela.addItem(tela.getNome());
        }
    }
    
    private void loadAcoes() {
        AcaoTela acaoForSearch = new AcaoTela();
        
        acaoForSearch.setTela(tela);
        
        acoes = SpringConfig.context.getBean(AcaoTelaService.class).find(acaoForSearch);
        
        comboUpdateAcao.removeAllItems();
        comboUpdateAcao.addItem("");

        for ( AcaoTela acao : acoes ) {
            comboUpdateAcao.addItem(acao.getAcao().getNome());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogInsert = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        fieldInsertNome = new javax.swing.JTextField();
        buttonInsertSalvar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        fieldInsertFuncionalidade = new javax.swing.JTextField();
        dialogUpdate = new javax.swing.JDialog();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldUpdateNome = new javax.swing.JTextField();
        fieldUpdateId = new javax.swing.JTextField();
        buttonUpdateSalvar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fieldUpdateFuncionalidade = new javax.swing.JTextField();
        comboUpdateAtivo = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        buttonAdicionarPermissao = new javax.swing.JButton();
        buttonRemoverPermissao = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePermissoes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboUpdateTela = new javax.swing.JComboBox<>();
        comboUpdateAcao = new javax.swing.JComboBox<>();
        buttonPesquisar = new javax.swing.JButton();
        buttonNovo = new javax.swing.JButton();
        comboSearchAtivo = new javax.swing.JComboBox<>();
        buttonEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableCargo = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        fieldSearchId = new javax.swing.JTextField();
        fieldSearchNome = new javax.swing.JTextField();

        dialogInsert.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogInsert.setTitle("Cadastrar Cargo");
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

        jLabel9.setText("*Funcionalidades:");

        javax.swing.GroupLayout dialogInsertLayout = new javax.swing.GroupLayout(dialogInsert.getContentPane());
        dialogInsert.getContentPane().setLayout(dialogInsertLayout);
        dialogInsertLayout.setHorizontalGroup(
            dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogInsertLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonInsertSalvar)
                    .addGroup(dialogInsertLayout.createSequentialGroup()
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogInsertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fieldInsertNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldInsertFuncionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 63, Short.MAX_VALUE))
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
                    .addComponent(fieldInsertFuncionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(buttonInsertSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dialogUpdate.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialogUpdate.setTitle("Atualizar Cargo");
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

        jLabel10.setText("*Funcionalidades:");

        jLabel12.setText("Ativo:");

        buttonAdicionarPermissao.setText("Adicionar Permissão");
        buttonAdicionarPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarPermissaoActionPerformed(evt);
            }
        });

        buttonRemoverPermissao.setText("Remover Permissão");
        buttonRemoverPermissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverPermissaoActionPerformed(evt);
            }
        });

        tablePermissoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tela", "Ação"
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
        tablePermissoes.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tablePermissoes);

        jLabel7.setText("Tela:");

        jLabel8.setText("Ação:");

        comboUpdateTela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboUpdateTelaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dialogUpdateLayout = new javax.swing.GroupLayout(dialogUpdate.getContentPane());
        dialogUpdate.getContentPane().setLayout(dialogUpdateLayout);
        dialogUpdateLayout.setHorizontalGroup(
            dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogUpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fieldUpdateId, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldUpdateNome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldUpdateFuncionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addComponent(comboUpdateAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(buttonUpdateSalvar)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogUpdateLayout.createSequentialGroup()
                                    .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogUpdateLayout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                        .addGroup(dialogUpdateLayout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addGap(14, 14, 14)))
                                    .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboUpdateTela, 0, 222, Short.MAX_VALUE)
                                        .addComponent(comboUpdateAcao, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(dialogUpdateLayout.createSequentialGroup()
                                .addComponent(buttonAdicionarPermissao)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(buttonRemoverPermissao)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dialogUpdateLayout.createSequentialGroup()
                        .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(jSeparator1))
                        .addContainerGap())))
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
                    .addComponent(fieldUpdateFuncionalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboUpdateAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttonUpdateSalvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboUpdateTela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(comboUpdateAcao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(dialogUpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAdicionarPermissao)
                    .addComponent(buttonRemoverPermissao))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Cargos");

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

        buttonEditar.setText("Editar");
        buttonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("ID:");

        jLabel2.setText("Nome:");

        tableCargo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Ativo"
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
        tableCargo.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tableCargo);

        jLabel3.setText("Ativo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonEditar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldSearchId, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fieldSearchNome, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboSearchAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboSearchAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonPesquisar)
                    .addComponent(buttonNovo)
                    .addComponent(buttonEditar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPesquisarActionPerformed
        load();
    }//GEN-LAST:event_buttonPesquisarActionPerformed

    private void buttonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNovoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Cargo();

                fieldInsertNome.setText("");
                fieldInsertFuncionalidade.setText("");

                dialogInsert.setLocationRelativeTo(null);
                dialogInsert.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonNovoActionPerformed

    private void buttonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity = new Cargo();
                entity.setId((Integer) tableCargo.getValueAt(tableCargo.getSelectedRow(), 0));

                entity = SpringConfig.context.getBean(CargoService.class).find(entity).get(0);

                fieldUpdateId.setText(String.valueOf(entity.getId()));
                fieldUpdateNome.setText(entity.getNome());
                fieldUpdateFuncionalidade.setText(entity.getFuncionalidade());

                comboUpdateAtivo.removeAllItems();
                
                for ( SimNaoType simNao : SimNaoType.values() ) {
                    comboUpdateAtivo.addItem(simNao.getValue());
                }
                
                comboUpdateAtivo.setSelectedIndex(Arrays.asList(SimNaoType.values()).indexOf(entity.getAtivo()));
                
                loadTelas();
                loadPermissoes();

                dialogUpdate.setLocationRelativeTo(null);
                dialogUpdate.setVisible(true);
            }
        });
    }//GEN-LAST:event_buttonEditarActionPerformed

    private void buttonInsertSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonInsertSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldInsertNome.getText());
                entity.setFuncionalidade(fieldInsertFuncionalidade.getText());
                entity.setAtivo(SimNaoType.SIM);

                CargoService service = SpringConfig.context.getBean(CargoService.class);

                service.insert(entity);

                fieldInsertNome.setText("");
                fieldInsertFuncionalidade.setText("");

                dialogInsert.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonInsertSalvarActionPerformed

    private void buttonUpdateSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateSalvarActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                entity.setNome(fieldUpdateNome.getText());
                entity.setFuncionalidade(fieldUpdateFuncionalidade.getText());
                entity.setAtivo(Arrays.asList(SimNaoType.values()).get(comboUpdateAtivo.getSelectedIndex()));

                CargoService service = SpringConfig.context.getBean(CargoService.class);

                service.update(entity);

                fieldUpdateNome.setText("");
                fieldUpdateFuncionalidade.setText("");

                dialogUpdate.dispose();
                load();
            }
        });
    }//GEN-LAST:event_buttonUpdateSalvarActionPerformed

    private void buttonRemoverPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverPermissaoActionPerformed
        SpringConfig.context.getBean(CargoAcaoTelaService.class).delete(permissoes.get(tablePermissoes.getSelectedRow()));
    }//GEN-LAST:event_buttonRemoverPermissaoActionPerformed

    private void comboUpdateTelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboUpdateTelaActionPerformed
        if ( comboUpdateTela.getSelectedIndex() != 0 ) {
            loadAcoes();
            
            comboUpdateAcao.setEnabled(true);
        } else {
            comboUpdateAcao.removeAllItems();
            comboUpdateAcao.setEnabled(false);
        }
    }//GEN-LAST:event_comboUpdateTelaActionPerformed

    private void buttonAdicionarPermissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarPermissaoActionPerformed
        CargoAcaoTela cargoAcaoTela = new CargoAcaoTela();
        
        cargoAcaoTela.setCargo(entity);
        cargoAcaoTela.setAcaoTela(acoes.get(comboUpdateAcao.getSelectedIndex()));
        
        SpringConfig.context.getBean(CargoAcaoTelaService.class).insert(cargoAcaoTela);
    }//GEN-LAST:event_buttonAdicionarPermissaoActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TelaCargo dialog = new TelaCargo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton buttonAdicionarPermissao;
    private javax.swing.JButton buttonEditar;
    private javax.swing.JButton buttonInsertSalvar;
    private javax.swing.JButton buttonNovo;
    private javax.swing.JButton buttonPesquisar;
    private javax.swing.JButton buttonRemoverPermissao;
    private javax.swing.JButton buttonUpdateSalvar;
    private javax.swing.JComboBox<String> comboSearchAtivo;
    private javax.swing.JComboBox<String> comboUpdateAcao;
    private javax.swing.JComboBox<String> comboUpdateAtivo;
    private javax.swing.JComboBox<String> comboUpdateTela;
    private javax.swing.JDialog dialogInsert;
    private javax.swing.JDialog dialogUpdate;
    private javax.swing.JTextField fieldInsertFuncionalidade;
    private javax.swing.JTextField fieldInsertNome;
    private javax.swing.JTextField fieldSearchId;
    private javax.swing.JTextField fieldSearchNome;
    private javax.swing.JTextField fieldUpdateFuncionalidade;
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
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tableCargo;
    private javax.swing.JTable tablePermissoes;
    // End of variables declaration//GEN-END:variables
}
