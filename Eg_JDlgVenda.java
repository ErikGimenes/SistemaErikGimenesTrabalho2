package eg_view;

import dao.ClientesDAO;
import bean.EgClientes;
import bean.EgVenda;
import bean.EgVendedor;
import bean.EgVendaProdutos;
import dao.VendaDAO;
import dao.VendedorDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tools.Util;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 * @author 08111349114
 */
public class Eg_JDlgVenda extends javax.swing.JDialog {

    boolean pesquisando = false;
    private boolean incluir;
    private MaskFormatter mascaraDataNasc;
    VendasProdutosControle vendasProdutosControle;

    public Eg_JDlgVenda(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);

        habilitarCampos(false);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);

        ClientesDAO clientesDAO = new ClientesDAO();
        List<EgClientes> listaClientes = (List<EgClientes>) clientesDAO.listar();
        for (EgClientes cliente : listaClientes) {
            jCboClientes.addItem(cliente);
        }

        VendedorDAO vendedorDAO = new VendedorDAO();
        List<EgVendedor> listaVendedores = (List<EgVendedor>) vendedorDAO.listar();
        for (EgVendedor vendedor : listaVendedores) {
            jCboVendedor.addItem(vendedor);
        }
        try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            jFmtData.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(Eg_JDlgVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date agora = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
                jLabel6.setText(formato.format(agora));
            }
        });
        timer.start();

        vendasProdutosControle = new VendasProdutosControle();
        List<EgVendaProdutos> lista = new ArrayList<EgVendaProdutos>();
        vendasProdutosControle.setList(lista);
        jTable2.setModel(vendasProdutosControle);
    }

    public void habilitarCampos(boolean enable) {
        jTxtCodigo.setEnabled(enable);
        jFmtData.setEnabled(enable);
        jCboClientes.setEnabled(enable);
        jCboVendedor.setEnabled(enable);
        jTxtTotal.setEnabled(enable);
        jBtnConfirmar.setEnabled(enable);
        jBtnCancelar.setEnabled(enable);
        jBtnIncluirProd.setEnabled(enable);
        jBtnAlterarProd.setEnabled(enable);
        jBtnExcluirProd.setEnabled(enable);
    }

    public void limparCampos() {
        jTxtCodigo.setText("");
        jFmtData.setText("");
        jCboClientes.setSelectedIndex(-1);
        jCboVendedor.setSelectedIndex(-1);
        jTxtTotal.setText("");
        vendasProdutosControle.setList(new ArrayList<EgVendaProdutos>());
    }

    public void addVendaProduto(EgVendaProdutos egVendaProdutos) {
        vendasProdutosControle.addBean(egVendaProdutos);
    }

    public void updateVendaProduto(EgVendaProdutos egVendaProdutos, int linhaSelecionada) {
        vendasProdutosControle.updateBean(linhaSelecionada, egVendaProdutos);
    }

    public EgVenda viewBean() {
        EgVenda jjmvendas = new EgVenda();
        jjmvendas.setIdVenda(Util.strToInt(jTxtCodigo.getText()));
        jjmvendas.setEgClientes((EgClientes) jCboClientes.getSelectedItem());
        jjmvendas.setEgVendedor((EgVendedor) jCboVendedor.getSelectedItem());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date dataNasc = formato.parse(jFmtData.getText());
            jjmvendas.setDataVenda(dataNasc);
        } catch (ParseException ex) {
            Logger.getLogger(Eg_JDlgVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
        jjmvendas.setValorTotal(Util.strToDuble(jTxtTotal.getText()));
        return jjmvendas;
    }

    public void beanView(EgVenda jjmVenda) {
        jTxtCodigo.setText(String.valueOf(jjmVenda.getIdVenda()));
        jCboClientes.setSelectedItem(jjmVenda.getEgClientes());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String dataNasc = formato.format(jjmVenda.getDataVenda());
        jFmtData.setText(dataNasc);
        jCboVendedor.setSelectedItem(jjmVenda.getEgVendedor());
        jTxtTotal.setText(Util.doubleToStr(jjmVenda.getValorTotal()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTxtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jFmtData = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jCboClientes = new javax.swing.JComboBox<EgClientes>();
        jCboVendedor = new javax.swing.JComboBox<EgVendedor>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtTotal = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBtnIncluir = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jBtnExcluir = new javax.swing.JButton();
        jBtnConfirmar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnPesquisar = new javax.swing.JButton();
        jBtnIncluirProd = new javax.swing.JButton();
        jBtnAlterarProd = new javax.swing.JButton();
        jBtnExcluirProd = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Codigo");

        jLabel2.setText("Data");

        jLabel3.setText("Clientes");

        jLabel4.setText("Vendedor");

        jLabel5.setText("Total");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluir.setText("Incluir");
        jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirActionPerformed(evt);
            }
        });

        jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterar.setText("Alterar");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluir.setText("Excluir");
        jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirActionPerformed(evt);
            }
        });

        jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jBtnConfirmar.setText("Confirmar");
        jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnConfirmarActionPerformed(evt);
            }
        });

        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jBtnCancelar.setText("Cancelar");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jBtnPesquisar.setText("Pesquisar");
        jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnPesquisarActionPerformed(evt);
            }
        });

        jBtnIncluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jBtnIncluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnIncluirProdActionPerformed(evt);
            }
        });

        jBtnAlterarProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jBtnAlterarProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarProdActionPerformed(evt);
            }
        });

        jBtnExcluirProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jBtnExcluirProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnExcluirProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jBtnAlterarProd)
                                .addComponent(jBtnIncluirProd)
                                .addComponent(jBtnExcluirProd)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(46, 46, 46)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(97, 97, 97)
                                            .addComponent(jLabel3))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(7, 7, 7)
                                            .addComponent(jLabel4)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(146, 146, 146)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnPesquisar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jFmtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jCboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTxtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCboVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jBtnIncluirProd)
                        .addGap(7, 7, 7)
                        .addComponent(jBtnAlterarProd)
                        .addGap(4, 4, 4)
                        .addComponent(jBtnExcluirProd)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnIncluir)
                    .addComponent(jBtnAlterar)
                    .addComponent(jBtnExcluir)
                    .addComponent(jBtnConfirmar)
                    .addComponent(jBtnCancelar)
                    .addComponent(jBtnPesquisar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirActionPerformed
        habilitarCampos(true);
        limparCampos();
        incluir = true;
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }//GEN-LAST:event_jBtnIncluirActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        habilitarCampos(true);
        incluir = false;
        Util.habilitar(false, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirActionPerformed
        if (Util.perguntar("Deseja excluir o registro?")) {
            EgVenda venda = viewBean();
            VendaDAO vendaDAO = new VendaDAO();
            vendaDAO.delete(venda);
            Util.mensagem("Registro excluído com sucesso!");
            limparCampos();
            habilitarCampos(false);
            Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
            Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
        }
    }//GEN-LAST:event_jBtnExcluirActionPerformed

    private void jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnConfirmarActionPerformed
        EgVenda venda = viewBean();
        VendaDAO vendaDAO = new VendaDAO();
        
        // Calcular o valor total da venda baseado nos produtos
        double valorTotal = 0;
        List<EgVendaProdutos> produtos = vendasProdutosControle.getList();
        for (EgVendaProdutos vp : produtos) {
            valorTotal += vp.getQuantidade() * vp.getValorUnitario();
        }
        venda.setValorTotal(valorTotal);
        
        if (incluir) {
            vendaDAO.insert(venda);
            // Salvar os produtos da venda
            dao.VendaProdutosDAO vendaProdutosDAO = new dao.VendaProdutosDAO();
            for (EgVendaProdutos vp : produtos) {
                vp.setEgVenda(venda);
                vendaProdutosDAO.insert(vp);
            }
        } else {
            vendaDAO.update(venda);
            // Atualizar produtos da venda
            dao.VendaProdutosDAO vendaProdutosDAO = new dao.VendaProdutosDAO();
            vendaProdutosDAO.deletePorVenda(venda.getIdVenda());
            for (EgVendaProdutos vp : produtos) {
                vp.setEgVenda(venda);
                vendaProdutosDAO.insert(vp);
            }
        }
        Util.mensagem("Registro salvo com sucesso!");
        limparCampos();
        habilitarCampos(false);
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
    }//GEN-LAST:event_jBtnConfirmarActionPerformed

    private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
        habilitarCampos(false);
        limparCampos();
        Util.habilitar(true, jBtnIncluir, jBtnAlterar, jBtnExcluir, jBtnPesquisar);
        Util.habilitar(false, jBtnConfirmar, jBtnCancelar, jBtnIncluirProd, jBtnAlterarProd, jBtnExcluirProd);
    }//GEN-LAST:event_jBtnCancelarActionPerformed

    private void jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnPesquisarActionPerformed

    private void jBtnIncluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnIncluirProdActionPerformed
        Eg_JDlgVendasProdutos eg_JDlgVendasProdutos = new Eg_JDlgVendasProdutos(null, true);
        eg_JDlgVendasProdutos.setTelaAnterior(this);
        eg_JDlgVendasProdutos.setVisible(true);
    }//GEN-LAST:event_jBtnIncluirProdActionPerformed

    private void jBtnAlterarProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarProdActionPerformed
        int linhaSelecionada = jTable2.getSelectedRow();
        if (linhaSelecionada != -1) {
            EgVendaProdutos egVendaProdutos = vendasProdutosControle.getBean(linhaSelecionada);
            Eg_JDlgVendasProdutos eg_JDlgVendasProdutos = new Eg_JDlgVendasProdutos(null, true, egVendaProdutos, linhaSelecionada);
            eg_JDlgVendasProdutos.setTelaAnterior(this);
            eg_JDlgVendasProdutos.setVisible(true);
        } else {
            Util.mensagem("Selecione um produto para alterar.");
        }
    }//GEN-LAST:event_jBtnAlterarProdActionPerformed

    private void jBtnExcluirProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnExcluirProdActionPerformed
        int linhaSelecionada = jTable2.getSelectedRow();
        if (linhaSelecionada != -1) {
            if (Util.perguntar("Deseja excluir o produto selecionado?")) {
                vendasProdutosControle.removeBean(linhaSelecionada);
            }
        } else {
            Util.mensagem("Selecione um produto para excluir.");
        }
    }//GEN-LAST:event_jBtnExcluirProdActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Eg_JDlgVenda dialog = new Eg_JDlgVenda(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnAlterarProd;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnConfirmar;
    private javax.swing.JButton jBtnExcluir;
    private javax.swing.JButton jBtnExcluirProd;
    private javax.swing.JButton jBtnIncluir;
    private javax.swing.JButton jBtnIncluirProd;
    private javax.swing.JButton jBtnPesquisar;
    private javax.swing.JComboBox<EgClientes> jCboClientes;
    private javax.swing.JComboBox<EgVendedor> jCboVendedor;
    private javax.swing.JFormattedTextField jFmtData;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTxtCodigo;
    private javax.swing.JTextField jTxtTotal;
    // End of variables declaration//GEN-END:variables
}

