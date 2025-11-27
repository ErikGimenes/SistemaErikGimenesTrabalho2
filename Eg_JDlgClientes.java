/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package eg_view;

import bean.EgClientes;
import dao.ClientesDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author 08111349114
 */
public class Eg_JDlgClientes extends javax.swing.JDialog {

    private ClientesDAO clientesDAO = new ClientesDAO();

    /**
     * Creates new form Eg_JDlgClientes
     */
        private boolean incluir; 
private MaskFormatter mascaraCpf, mascaraDataNasc;
     boolean pesquisando = false;
    public Eg_JDlgClientes(java.awt.Frame parent, boolean modal) {
       super(parent, modal);
        initComponents();
        setTitle("Cadastro de Usuarios");
        setLocationRelativeTo(null);
 Util.habilitar(false, eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento,
                   eg_jTxtCidade, eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra,
                   eg_jTxtEmail, eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo,
                   eg_jTxtTipodecliente, eg_jTxtCep, eg_jTxtTelefone,
                   eg_jTxtEndereco, eg_jTxtEstado);

    // Deixa Confirmar e Cancelar desabilitados
    eg_jBtnConfirmar.setEnabled(false);
    eg_jBtnCancelar.setEnabled(false);

try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            eg_jFmtDatadenascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(Eg_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            eg_jFmtDatadaultimacompra.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(Eg_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);        }
Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date agora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        jLabel1.setText(formato.format(agora));
    }
});
timer.start();

            }
    

    
    public EgClientes viewBean() {
    EgClientes jjmClientes = new EgClientes();

    jjmClientes.setIdCliente(Util.strToInt(eg_jTxtCodigo.getText()));
    jjmClientes.setNome(eg_jTxtNome.getText());
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dataNasc = formato.parse(eg_jFmtDatadenascimento.getText());
                    jjmClientes.setDataNasc(dataNasc);
                } catch (ParseException ex) {
                    Logger.getLogger(Eg_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
    jjmClientes.setCidade(eg_jTxtCidade.getText());
    jjmClientes.setFormaPagamento(eg_jTxtFormadepagamento.getText());
   try {
                    Date dataNasc = formato.parse(eg_jFmtDatadaultimacompra.getText());
                    jjmClientes.setDataUltimaCompra(dataNasc);
                } catch (ParseException ex) {
                    Logger.getLogger(Eg_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
    jjmClientes.setEmail(eg_jTxtEmail.getText());
   jjmClientes.setCep(eg_jTxtCep.getText());
    jjmClientes.setBairro(eg_jTxtBairro.getText());
    jjmClientes.setSexo(eg_jTxtSexo.getText());
    jjmClientes.setTipoCliente(eg_jTxtTipodecliente.getText());
   jjmClientes.setTelefone(eg_jTxtTelefone.getText());
    jjmClientes.setEndereco(eg_jTxtEndereco.getText());
    jjmClientes.setEstado(eg_jTxtEstado.getText());

    return jjmClientes;
}

public void beanView(EgClientes jjmClientes) {
    eg_jTxtCodigo.setText(Util.intToStr(jjmClientes.getIdCliente()));
  eg_jTxtNome.setText(jjmClientes.getNome());
 eg_jFmtDatadenascimento.setText(Util.dateToStr(jjmClientes.getDataNasc()));
    eg_jTxtCidade.setText(jjmClientes.getCidade());
    eg_jTxtFormadepagamento.setText(jjmClientes.getFormaPagamento());
    eg_jFmtDatadaultimacompra.setText(Util.dateToStr(jjmClientes.getDataUltimaCompra()));
    eg_jTxtEmail.setText(jjmClientes.getEmail());
    eg_jTxtRg.setText(jjmClientes.getRg());
    eg_jTxtBairro.setText(jjmClientes.getBairro());
    eg_jTxtSexo.setText(jjmClientes.getSexo());
    eg_jTxtTipodecliente.setText(jjmClientes.getTipoCliente());
    eg_jTxtCep.setText(jjmClientes.getCep());
    eg_jTxtTelefone.setText(jjmClientes.getTelefone());
    eg_jTxtEndereco.setText(jjmClientes.getEndereco());
    eg_jTxtEstado.setText(jjmClientes.getEstado());
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eg_jTxtTelefone = new javax.swing.JTextField();
        jLblEndereco = new javax.swing.JLabel();
        eg_jTxtEndereco = new javax.swing.JTextField();
        jLblDatadenascimento = new javax.swing.JLabel();
        eg_jFmtDatadenascimento = new javax.swing.JFormattedTextField();
        jLblFormadepagamento = new javax.swing.JLabel();
        eg_jFmtDatadaultimacompra = new javax.swing.JFormattedTextField();
        eg_jTxtFormadepagamento = new javax.swing.JTextField();
        JLblRg = new javax.swing.JLabel();
        eg_jTxtRg = new javax.swing.JTextField();
        jLblTipodecliente = new javax.swing.JLabel();
        eg_jTxtTipodecliente = new javax.swing.JTextField();
        jLblCep = new javax.swing.JLabel();
        eg_jTxtCep = new javax.swing.JTextField();
        jLblEstado = new javax.swing.JLabel();
        jLblCodigo = new javax.swing.JLabel();
        eg_jTxtEstado = new javax.swing.JTextField();
        eg_jTxtCodigo = new javax.swing.JTextField();
        jLblCidade = new javax.swing.JLabel();
        jLblNome = new javax.swing.JLabel();
        eg_jTxtCidade = new javax.swing.JTextField();
        eg_jTxtNome = new javax.swing.JTextField();
        jLblDataDaUltimaCompra = new javax.swing.JLabel();
        jLblEmail = new javax.swing.JLabel();
        jLblBairro = new javax.swing.JLabel();
        eg_jTxtEmail = new javax.swing.JTextField();
        eg_jTxtBairro = new javax.swing.JTextField();
        jLblSexo = new javax.swing.JLabel();
        eg_jTxtSexo = new javax.swing.JTextField();
        jLblTelefone = new javax.swing.JLabel();
        eg_jBtnAlterar = new javax.swing.JButton();
        eg_jBtnExcluir = new javax.swing.JButton();
        eg_jBtnConfirmar = new javax.swing.JButton();
        eg_jBtnCancelar = new javax.swing.JButton();
        eg_jBtnPesquisar = new javax.swing.JButton();
        eg_jBtnIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        eg_jTxtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtTelefoneActionPerformed(evt);
            }
        });

        jLblEndereco.setText("Endereco");

        eg_jTxtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtEnderecoActionPerformed(evt);
            }
        });

        jLblDatadenascimento.setText("Data de Nascimento");

        jLblFormadepagamento.setText("Forma de Pagamento");

        eg_jTxtFormadepagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtFormadepagamentoActionPerformed(evt);
            }
        });

        JLblRg.setText("Rg:");

        eg_jTxtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtRgActionPerformed(evt);
            }
        });

        jLblTipodecliente.setText("Tipo De Cliente");

        eg_jTxtTipodecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtTipodeclienteActionPerformed(evt);
            }
        });

        jLblCep.setText("Cep");

        jLblEstado.setText("Estado:");

        jLblCodigo.setText("Codigo");

        eg_jTxtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtEstadoActionPerformed(evt);
            }
        });

        eg_jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtCodigoActionPerformed(evt);
            }
        });

        jLblCidade.setText("Cidade");

        jLblNome.setText("Nome:");

        eg_jTxtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtCidadeActionPerformed(evt);
            }
        });

        eg_jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtNomeActionPerformed(evt);
            }
        });

        jLblDataDaUltimaCompra.setText("Data da Ultima Compra ");

        jLblEmail.setText("Email:");

        jLblBairro.setText("Bairro");

        eg_jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtEmailActionPerformed(evt);
            }
        });

        eg_jTxtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtBairroActionPerformed(evt);
            }
        });

        jLblSexo.setText("Sexo:");

        eg_jTxtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jTxtSexoActionPerformed(evt);
            }
        });

        jLblTelefone.setText("Telefone:");

        eg_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        eg_jBtnAlterar.setText("Alterar");
        eg_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnAlterarActionPerformed(evt);
            }
        });

        eg_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        eg_jBtnExcluir.setText("Excluir");
        eg_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnExcluirActionPerformed(evt);
            }
        });

        eg_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        eg_jBtnConfirmar.setText("Confirmar");
        eg_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnConfirmarActionPerformed(evt);
            }
        });

        eg_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        eg_jBtnCancelar.setText("Cancelar");
        eg_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnCancelarActionPerformed(evt);
            }
        });

        eg_jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        eg_jBtnPesquisar.setText("Pesquisar");
        eg_jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnPesquisarActionPerformed(evt);
            }
        });

        eg_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        eg_jBtnIncluir.setText("Incluir");
        eg_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eg_jBtnIncluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(eg_jTxtTipodecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eg_jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eg_jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eg_jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eg_jTxtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eg_jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblDatadenascimento))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(eg_jFmtDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLblCodigo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eg_jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblFormadepagamento))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eg_jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(eg_jTxtFormadepagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eg_jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eg_jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eg_jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eg_jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eg_jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eg_jBtnPesquisar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblDataDaUltimaCompra)
                            .addComponent(jLblTipodecliente)
                            .addComponent(eg_jFmtDatadaultimacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLblCep)
                                .addGap(86, 86, 86)
                                .addComponent(jLblTelefone)
                                .addGap(72, 72, 72)
                                .addComponent(jLblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblEstado)
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eg_jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLblRg)
                                    .addComponent(eg_jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(eg_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblSexo)
                                    .addComponent(eg_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCodigo)
                    .addComponent(jLblDatadenascimento)
                    .addComponent(jLblCidade)
                    .addComponent(jLblNome)
                    .addComponent(jLblFormadepagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eg_jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jFmtDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtFormadepagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDataDaUltimaCompra)
                    .addComponent(jLblEmail)
                    .addComponent(JLblRg)
                    .addComponent(jLblBairro)
                    .addComponent(jLblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eg_jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eg_jFmtDatadaultimacompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblTipodecliente)
                            .addComponent(jLblCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eg_jTxtTipodecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eg_jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eg_jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eg_jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eg_jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblTelefone)
                        .addComponent(jLblEndereco)
                        .addComponent(jLblEstado)))
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(eg_jBtnIncluir)
                    .addComponent(eg_jBtnConfirmar)
                    .addComponent(eg_jBtnAlterar)
                    .addComponent(eg_jBtnCancelar)
                    .addComponent(eg_jBtnExcluir)
                    .addComponent(eg_jBtnPesquisar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eg_jTxtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtTelefoneActionPerformed

    private void eg_jTxtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtEnderecoActionPerformed

    private void eg_jTxtFormadepagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtFormadepagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtFormadepagamentoActionPerformed

    private void eg_jTxtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtRgActionPerformed

    private void eg_jTxtTipodeclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtTipodeclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtTipodeclienteActionPerformed

    private void eg_jTxtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtEstadoActionPerformed

    private void eg_jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtCodigoActionPerformed

    private void eg_jTxtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtCidadeActionPerformed

    private void eg_jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtNomeActionPerformed

    private void eg_jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtEmailActionPerformed

    private void eg_jTxtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtBairroActionPerformed

    private void eg_jTxtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jTxtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eg_jTxtSexoActionPerformed

    private void eg_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnAlterarActionPerformed
       Util.habilitar(true,  eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado,
        eg_jBtnConfirmar, eg_jBtnCancelar);
    Util.habilitar(false, eg_jBtnAlterar, eg_jBtnExcluir, eg_jBtnPesquisar, eg_jBtnIncluir);
    incluir=false;
    Util.limpar(eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado);
    }//GEN-LAST:event_eg_jBtnAlterarActionPerformed

    private void eg_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnExcluirActionPerformed

  if (Util.perguntar("Deseja Excluir?") == true) {
            ClientesDAO clientesDAO = new ClientesDAO();
            clientesDAO.delete(viewBean());
                Util.limpar(  eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado);  
        } 
    }//GEN-LAST:event_eg_jBtnExcluirActionPerformed

    private void eg_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnConfirmarActionPerfoClientesDAO clientesDAO = new ClientesDAO();
        if (incluir == true) {
            clientesDAO.insert(viewBean());
        } else {
            clientesDAO.update(viewBean());
        }
        Util.habilitar(false, 
        eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado,
        eg_jBtnConfirmar, eg_jBtnCancelar
    );
    Util.habilitar(true, eg_jBtnAlterar, eg_jBtnExcluir, eg_jBtnPesquisar, eg_jBtnIncluir);
          Util.limpar(  eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado);
    }//GEN-LAST:event_eg_jBtnConfirmarActionPerformed

    private void eg_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnCancelarActionPerformed
        Util.habilitar(false, 
        eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado,
        eg_jBtnConfirmar, eg_jBtnCancelar
    );
    Util.habilitar(true, eg_jBtnAlterar, eg_jBtnExcluir, eg_jBtnPesquisar, eg_jBtnIncluir);
          
          Util.limpar(  eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado);
    }//GEN-LAST:event_eg_jBtnCancelarActionPerformed

    private void eg_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        /* String id = JOptionPane.showInputDialog(null, "Entre com o código ?");
        int codigo = Integer.valueOf(id);
        ClientesDAO clientesDAO = new ClientesDAO();
        EgEgClientes clientes = (EgClientes) clientesDAO.list(codigo);   if (clientes == null) {
            JOptionPane.showMessageDialog(null, "Codigo nao existente");
        } else {
            eg_jTxtCodigo.setText(id);
            eg_jTxtNome.setText(clientes.getjjm_Nome());
            eg_jTxtEmail.setText(clientes.getjjm_Email());
            eg_jTxtSexo.setText(clientes.getjjm_Sexo());
            eg_jTxtTelefone.setText(clientes.getjjm_Telefone());
            eg_jTxtEndereco.setText(clientes.getjjm_Endereco());
            eg_jFmtDatadaultimacompra.setText(null);
            eg_jTxtFormadepagamento.setText(clientes.getjjm_Formadepagamento());
            eg_jTxtRg.setText(clientes.getjjm_Rg());
            eg_jTxtTipodecliente.setText(clientes.getjjm_Tipocliente());
            eg_jTxtCep.setText(clientes.getjjm_Cep());
            eg_jTxtEstado.setText(clientes.getjjm_Estado());
            eg_jTxtCidade.setText(clientes.getjjm_Cidade());
            eg_jFmtDatadenascimento.setText(null);
            eg_jTxtBairro.setText(clientes.getjjm_Bairro());
        }*/
        
        Eg_JDlgClientesPesquisar jDlgClientePesquisar = new Eg_JDlgClientesPesquisar(null, true);
        jDlgClientePesquisar.setTelaPai(this);
        jDlgClientePesquisar.setVisible(true);
        pesquisando = true;
    }//GEN-LAST:event_eg_jBtnPesquisarActionPerformed

    private void eg_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eg_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, 
        eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado,
        eg_jBtnConfirmar, eg_jBtnCancelar
    );
    Util.habilitar(false, eg_jBtnAlterar, eg_jBtnExcluir, eg_jBtnPesquisar, eg_jBtnIncluir);
eg_jTxtCodigo.grabFocus();
        incluir = true;

      
          Util.limpar(  eg_jTxtCodigo, eg_jTxtNome, eg_jFmtDatadenascimento, eg_jTxtCidade, 
        eg_jTxtFormadepagamento, eg_jFmtDatadaultimacompra, eg_jTxtEmail, 
        eg_jTxtRg, eg_jTxtBairro, eg_jTxtSexo, eg_jTxtTipodecliente, 
        eg_jTxtCep, eg_jTxtTelefone, eg_jTxtEndereco, eg_jTxtEstado);
       
    }//GEN-LAST:event_eg_jBtnIncluirActionPerformed

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
            java.util.logging.Logger.getLogger(Eg_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Eg_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Eg_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Eg_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Eg_JDlgClientes dialog = new Eg_JDlgClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel JLblRg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblBairro;
    private javax.swing.JLabel jLblCep;
    private javax.swing.JLabel jLblCidade;
    private javax.swing.JLabel jLblCodigo;
    private javax.swing.JLabel jLblDataDaUltimaCompra;
    private javax.swing.JLabel jLblDatadenascimento;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblEndereco;
    private javax.swing.JLabel jLblEstado;
    private javax.swing.JLabel jLblFormadepagamento;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JLabel jLblSexo;
    private javax.swing.JLabel jLblTelefone;
    private javax.swing.JLabel jLblTipodecliente;
    private javax.swing.JButton eg_jBtnAlterar;
    private javax.swing.JButton eg_jBtnCancelar;
    private javax.swing.JButton eg_jBtnConfirmar;
    private javax.swing.JButton eg_jBtnExcluir;
    private javax.swing.JButton eg_jBtnIncluir;
    private javax.swing.JButton eg_jBtnPesquisar;
    private javax.swing.JFormattedTextField eg_jFmtDatadaultimacompra;
    private javax.swing.JFormattedTextField eg_jFmtDatadenascimento;
    private javax.swing.JTextField eg_jTxtBairro;
    private javax.swing.JTextField eg_jTxtCep;
    private javax.swing.JTextField eg_jTxtCidade;
    private javax.swing.JTextField eg_jTxtCodigo;
    private javax.swing.JTextField eg_jTxtEmail;
    private javax.swing.JTextField eg_jTxtEndereco;
    private javax.swing.JTextField eg_jTxtEstado;
    private javax.swing.JTextField eg_jTxtFormadepagamento;
    private javax.swing.JTextField eg_jTxtNome;
    private javax.swing.JTextField eg_jTxtRg;
    private javax.swing.JTextField eg_jTxtSexo;
    private javax.swing.JTextField eg_jTxtTelefone;
    private javax.swing.JTextField eg_jTxtTipodecliente;
    // End of variables declaration//GEN-END:variables
}
