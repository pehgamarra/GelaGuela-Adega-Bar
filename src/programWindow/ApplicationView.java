package programWindow;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import help.Db;
import net.proteanit.sql.DbUtils;
import javax.swing.JRadioButton;

public class ApplicationView {
	
	//Variavel do JFrame
	private JFrame frmGelaGuelaBar;
	
	//Conexao com banco de dados
	private Connection conexao;
	PreparedStatement statement;
	
	//Variaveis da tela de login
	private JTextField textLogin;
	private JPasswordField txtSenha;
	
	//Tables da seção de Produtos
	private JTable tableProdutosNaAdega, tableProdutosParaComprar, tableProdutosEmEstoque, tableTodosProdutos;
	
	//Variaveis da Lista de Produtos na Adega
	private JTextField textFieldIdProdutosNaAdega, textFieldNomeProdutosNaAdega, textFieldQuantidadeProdutosNaAdega, textFieldPrecoProdutosNaAdega;

	//Variaveis da Lista de Estoque
	private JTextField textFieldPrecoProdutosEmEstoque, textFieldNomeProdutosEmEstoque, textFieldIdProdutosEmEstoque;
	private JTable tableProdutosNoCarrinhoVendaAtacado;
	private JTable tableClientesVendaAtacado_1;
	private JTextField textFieldIdDoProdutoVendaAtacado;
	private JTextField textField_QuantidadeUnidadeVendaAtacado;
	private JTextField txtIdDoClienteVendaAtacado;
	private JTextField textField_NomeDoProdutoVendaAtacado;
	private JTextField textField_PrecoVendaAtacado;
	private JTable tableProdutosVendaAtacado;
	private JTextField textFieldNomeClienteCarrinhoVendaAtacado;
	private JTable tablePrecoTotal;
	private JTextField textFieldPrecoTotalVendaAtacado;
	private JTextField textFieldNomeDaEmpresaVendaAtacado;
	private JTextField textFieldUnidadesProdutosEmEstoque;
	private JTextField textField_DescontoVendaAtacado;
	private JTextField txt_NumeroDaVendaAtacado;
	private JTextField textField_PrecoParaOCarrinhoVendaAtacado;
	private JTextField textFieldNomeProdutoVendaPersonalizada;
	private JTextField textField_QuantidadeVendaPersonalizada;
	private JTextField textField_ValorProdutoVendaPersonalizada;
	private JTextField textField_PrecoVendaPersonalizada;
	private JTable tableProdutosVendaPersonalizada;
	private JTextField textFieldIDVendaPersonalizada;
	private JTextField textField_NomeClienteVendaPersonalizada;
	private JTextField textField_CPFRGVendaPersonalizada;
	private JTextField textField_EmailVendaPersonalizada;
	private JTable tableCarrinhoVendaPersonalizada;
	private JTextField textField_TelefoneVendaPersonalizada;
	private JTextField textField_EmpresaVendaPersonalizada;
	private JTextField txt_NmrVendaVendaPersonalizada;
	private Double valorCarrinhoVarejo =0.0;
	private Double valorCarrinhoPersonalizada = 0.0;
	private JTextField txtValorTotal;
	private JTable table_ProdutoVendaVarejo;
	private JTextField textFieldProdutoVendaVarejo;
	private JTextField textField_PrecoVendaVarejo;
	private JTextField textField_QuantidadeVendaVarejo;
	private JTable table_CarrinhoVendaVarejo;
	private JTextField textField_ValorTotalVendaVarejo;
	private JTextField textField_ValorPagoVendaVarejo;
	private JTextField textField_TrocoVendaVarejo;
	private JTextField textFieldIDProdutoVendaVarejo;
	private JTextField textFieldVendaVendaVarejo;
	
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		 try {
	            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
	 
	        } catch (ClassNotFoundException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (InstantiationException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (IllegalAccessException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(ApplicationView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationView window = new ApplicationView();
					window.frmGelaGuelaBar.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationView() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGelaGuelaBar = new JFrame();
		frmGelaGuelaBar.setResizable(false);
		frmGelaGuelaBar.setTitle("Gela Guela Bar & Adega - Application");
		frmGelaGuelaBar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\youtube-shop-icon.png"));
		frmGelaGuelaBar.setBackground(Color.BLACK);
		frmGelaGuelaBar.setBounds(100, 100, 798, 595);
		frmGelaGuelaBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGelaGuelaBar.getContentPane().setLayout(new CardLayout(0, 0));
		frmGelaGuelaBar.setLocationRelativeTo(null);
		conexao = Db.getConnection();


		JPanel telaDeLogin = new JPanel();
		frmGelaGuelaBar.getContentPane().add(telaDeLogin, "name_6482692391000");
		telaDeLogin.setLayout(null);

		JPanel menuInicial = new JPanel();
		frmGelaGuelaBar.getContentPane().add(menuInicial, "name_6512104216800");
		menuInicial.setLayout(null);

		JPanel produtosNaAdega = new JPanel();
		produtosNaAdega.setFocusable(false);
		frmGelaGuelaBar.getContentPane().add(produtosNaAdega, "name_10148521687100");

		JPanel produtosEmEstoque = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosEmEstoque, "name_10170212866500");
		produtosEmEstoque.setLayout(null);

		JPanel produtosParaComprar = new JPanel();
		frmGelaGuelaBar.getContentPane().add(produtosParaComprar, "name_10173299634900");
		produtosParaComprar.setLayout(null);

		JPanel todosProdutos = new JPanel();
		frmGelaGuelaBar.getContentPane().add(todosProdutos, "name_10175652732000");
		todosProdutos.setLayout(null);

		JPanel vendaVarejo = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaVarejo, "name_10177535959400");
		vendaVarejo.setLayout(null);

		JPanel vendaAtacado = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaAtacado, "name_10180454744300");

		JPanel vendaPersonalizada = new JPanel();
		frmGelaGuelaBar.getContentPane().add(vendaPersonalizada, "name_10251987733900");
		vendaPersonalizada.setLayout(null);

		JPanel fluxoDeCaixa = new JPanel();
		frmGelaGuelaBar.getContentPane().add(fluxoDeCaixa, "name_10261460448500");
		fluxoDeCaixa.setLayout(null);

		JPanel entrada = new JPanel();
		frmGelaGuelaBar.getContentPane().add(entrada, "name_10265053203100");
		entrada.setLayout(null);

		JPanel saida = new JPanel();
		frmGelaGuelaBar.getContentPane().add(saida, "name_10266988574700");
		saida.setLayout(null);

		JPanel custoXvenda = new JPanel();
		frmGelaGuelaBar.getContentPane().add(custoXvenda, "name_10268519796800");
		custoXvenda.setLayout(null);

		JPanel orcamentoDiario = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoDiario, "name_10271596026600");
		orcamentoDiario.setLayout(null);

		JPanel orcamentoMensal = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoMensal, "name_10393550066500");
		orcamentoMensal.setLayout(null);

		JPanel orcamentoAnual = new JPanel();
		frmGelaGuelaBar.getContentPane().add(orcamentoAnual, "name_10409225634100");
		orcamentoAnual.setLayout(null);
		
		
		
		
		//
		//
		// Menu Inicial
		//
		//
		
		
		JMenuBar menuBarMenuInicial = new JMenuBar();
		menuBarMenuInicial.setBackground(Color.LIGHT_GRAY);
		menuBarMenuInicial.setBounds(0, 0, 934, 22);
		menuInicial.add(menuBarMenuInicial);

		JMenu mnProdutosMenuInicial = new JMenu("Produtos");
		mnProdutosMenuInicial.setToolTipText("");
		mnProdutosMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarMenuInicial.add(mnProdutosMenuInicial);

		JMenuItem mntmProdutosNaAdegaMenuInicial = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmProdutosNaAdegaMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosNaAdegaMenuInicial);

		JMenuItem mntmProdutosEmEstoqueMenuInicial = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosEmEstoqueMenuInicial);

		JMenuItem mntmProdutosParaComprarMenuInicial = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosMenuInicial.add(mntmProdutosParaComprarMenuInicial);

		JMenuItem mntmTodosProdutosMenuInicial = new JMenuItem("Todos Produtos");
		mntmTodosProdutosMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				menuInicial.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosMenuInicial.add(mntmTodosProdutosMenuInicial);

		JMenu mnVenderMenuInicial = new JMenu("Vender");
		mnVenderMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarMenuInicial.add(mnVenderMenuInicial);

		JMenuItem mntmVendaVarejoMenuInicial = new JMenuItem("Venda Varejo");
		mntmVendaVarejoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderMenuInicial.add(mntmVendaVarejoMenuInicial);

		JMenuItem mntmVendaAtacadoMenuInicial = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderMenuInicial.add(mntmVendaAtacadoMenuInicial);

		JMenuItem mntmVendaPersonalizadaMenuInicial = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderMenuInicial.add(mntmVendaPersonalizadaMenuInicial);
		
		JMenu mnClientesMenuInicial = new JMenu("Clientes");
		mnClientesMenuInicial.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarMenuInicial.add(mnClientesMenuInicial);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesMenuInicial.add(mntmNewMenuItem);

		JMenu mnFinanceiroMenuInicial = new JMenu("Financeiro");
		mnFinanceiroMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarMenuInicial.add(mnFinanceiroMenuInicial);

		JMenu mnAjudaMenuInicial = new JMenu("Ajuda");
		mnAjudaMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarMenuInicial.add(mnAjudaMenuInicial);

		JMenuItem mntmDadosDaVersaoMenuInicial = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaMenuInicial.add(mntmDadosDaVersaoMenuInicial);

		JLabel lblNewLabelImagemDeFundoMenuInicial = new JLabel("");
		lblNewLabelImagemDeFundoMenuInicial
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\jw-portada.jpg"));
		lblNewLabelImagemDeFundoMenuInicial.setBounds(-140, 5, 941, 722);
		menuInicial.add(lblNewLabelImagemDeFundoMenuInicial);
		telaDeLogin.setLayout(null);
		produtosNaAdega.setLayout(null);

		//
		//
		// Produtos Na Adega
		//
		//

		JMenuBar menuBarProdutosNaAdega = new JMenuBar();
		menuBarProdutosNaAdega.setBounds(0, 0, 934, 22);
		menuBarProdutosNaAdega.setBackground(Color.LIGHT_GRAY);
		produtosNaAdega.add(menuBarProdutosNaAdega);

		JMenu mnProdutosProdutosNaAdega = new JMenu("Produtos");
		mnProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosNaAdega.add(mnProdutosProdutosNaAdega);

		JMenuItem mntmProdutosNaAdegaProdutosNaAdega = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmProdutosNaAdegaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosNaAdegaProdutosNaAdega);

		JMenuItem mntmProdutosEmEstoqueProdutosNaAdega = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosEmEstoqueProdutosNaAdega);

		JMenuItem mntmProdutosParaComprarProdutosNaAdega = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmProdutosParaComprarProdutosNaAdega);

		JMenuItem mntmTodosProdutosProdutosNaAdega = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosNaAdega.add(mntmTodosProdutosProdutosNaAdega);

		JMenu mnVenderProdutosNaAdega = new JMenu("Vender");
		mnVenderProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosNaAdega.add(mnVenderProdutosNaAdega);

		JMenuItem mntmVendaVarejoProdutosNaAdega = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaVarejoProdutosNaAdega);

		JMenuItem mntmVendaAtacadoProdutosNaAdega = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaAtacadoProdutosNaAdega);

		JMenuItem mntmVendaPersonalizadaProdutosNaAdega = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosNaAdega.add(mntmVendaPersonalizadaProdutosNaAdega);
		
		JMenu mnClientesProdutosNaAdega = new JMenu("Clientes");
		mnClientesProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosNaAdega.add(mnClientesProdutosNaAdega);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosNaAdega.add(mntmNewMenuItem_1);

		JMenu mnFinanceiroProdutosNaAdega = new JMenu("Financeiro");
		mnFinanceiroProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosNaAdega.add(mnFinanceiroProdutosNaAdega);

		JMenu mnAjudaProdutosNaAdega = new JMenu("Ajuda");
		mnAjudaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosNaAdega.add(mnAjudaProdutosNaAdega);

		JMenuItem mntmDadosDaVersaoProdutosNaAdega = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosNaAdega.add(mntmDadosDaVersaoProdutosNaAdega);

		JScrollPane scrollPaneProdutosNaAdega = new JScrollPane();
		scrollPaneProdutosNaAdega.setBounds(270, 77, 504, 471);
		produtosNaAdega.add(scrollPaneProdutosNaAdega);

		tableProdutosNaAdega = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosNaAdega.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosNaAdega.getSelectedRow();
				textFieldIdProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 0).toString());
				textFieldNomeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosNaAdega.setText(tableProdutosNaAdega.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosNaAdega.setViewportView(tableProdutosNaAdega);

		JButton btnListarProdutosNaAdega = new JButton("Mostrar Produtos da Adega");
		btnListarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosNaAdega();
			}
		});
		btnListarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		btnListarProdutosNaAdega.setBounds(402, 33, 252, 33);
		produtosNaAdega.add(btnListarProdutosNaAdega);

		JLabel lblIdProdutosNaAdega = new JLabel("ID do Produto : ");
		lblIdProdutosNaAdega.setVisible(false);
		lblIdProdutosNaAdega.setForeground(Color.WHITE);
		lblIdProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosNaAdega.setBounds(39, 85, 97, 20);
		produtosNaAdega.add(lblIdProdutosNaAdega);

		JLabel lblNomeProdutosNaAdega = new JLabel("Nome :");
		lblNomeProdutosNaAdega.setForeground(Color.WHITE);
		lblNomeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosNaAdega.setBounds(85, 115, 48, 20);
		produtosNaAdega.add(lblNomeProdutosNaAdega);

		JLabel lblQuantidadeProdutosNaAdega = new JLabel("Quantidade (UN) :");
		lblQuantidadeProdutosNaAdega.setForeground(Color.WHITE);
		lblQuantidadeProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosNaAdega.setBounds(25, 145, 109, 20);
		produtosNaAdega.add(lblQuantidadeProdutosNaAdega);

		JLabel lblPrecoProdutosNaAdega = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosNaAdega.setForeground(Color.WHITE);
		lblPrecoProdutosNaAdega.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosNaAdega.setBounds(86, 175, 48, 20);
		produtosNaAdega.add(lblPrecoProdutosNaAdega);

		textFieldIdProdutosNaAdega = new JTextField();
		textFieldIdProdutosNaAdega.setVisible(false);
		textFieldIdProdutosNaAdega.setBounds(154, 85, 86, 20);
		produtosNaAdega.add(textFieldIdProdutosNaAdega);
		textFieldIdProdutosNaAdega.setColumns(10);

		textFieldNomeProdutosNaAdega = new JTextField();
		textFieldNomeProdutosNaAdega.setBounds(154, 115, 86, 20);
		produtosNaAdega.add(textFieldNomeProdutosNaAdega);
		textFieldNomeProdutosNaAdega.setColumns(10);

		textFieldQuantidadeProdutosNaAdega = new JTextField();
		textFieldQuantidadeProdutosNaAdega.setBounds(154, 145, 86, 20);
		produtosNaAdega.add(textFieldQuantidadeProdutosNaAdega);
		textFieldQuantidadeProdutosNaAdega.setColumns(10);

		textFieldPrecoProdutosNaAdega = new JTextField();
		textFieldPrecoProdutosNaAdega.setBounds(154, 175, 86, 20);
		produtosNaAdega.add(textFieldPrecoProdutosNaAdega);
		textFieldPrecoProdutosNaAdega.setColumns(10);

		JButton btnAdicionarProdutosNaAdega = new JButton("Adicionar");
		btnAdicionarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
						if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
							if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
								try {
									String query = "insert into lojaTatuape (Nome, Unidades, Preco) values (?, ?, ?)";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.setString(1, textFieldNomeProdutosNaAdega.getText());
									pst.setString(2, textFieldQuantidadeProdutosNaAdega.getText());
									pst.setString(3, textFieldPrecoProdutosNaAdega.getText());
										pst.execute();
									JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
				
									pst.close();
								} catch (Exception g) {
									JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
								}
								refreshtableProdutosNaAdega();
	
							}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdicionarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosNaAdega.setBounds(85, 225, 113, 25);
		produtosNaAdega.add(btnAdicionarProdutosNaAdega);

		JButton btnAtualizarProdutosNaAdega = new JButton("Atualizar");
		btnAtualizarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
		        	if(!textFieldIdProdutosNaAdega.getText().equals("")) {
			        	if(!textFieldNomeProdutosNaAdega.getText().equals("")) {
							if(!textFieldQuantidadeProdutosNaAdega.getText().equals("")) {
								if(!textFieldPrecoProdutosNaAdega.getText().equals("")) {	
									try {
									String query = "Update lojaTatuape set Id='" + textFieldIdProdutosNaAdega.getText() + "' ,Nome = '"
											+ textFieldNomeProdutosNaAdega.getText() + "' ,Unidades = '"
											+ textFieldQuantidadeProdutosNaAdega.getText() + "' ,Preco = '"
											+ textFieldPrecoProdutosNaAdega.getText() + "' where Id='"
											+ textFieldIdProdutosNaAdega.getText() + "'  ";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.execute();
									pst.close();
									JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
									
									} catch (Exception g) {
										JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
									}
									refreshtableProdutosNaAdega();
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			      } else {
			       		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			    }
			}
		});
		btnAtualizarProdutosNaAdega.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosNaAdega.setBounds(85, 260, 113, 25);
		produtosNaAdega.add(btnAtualizarProdutosNaAdega);

		JButton btnDeletarProdutosNaAdega = new JButton("Deletar");
		btnDeletarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
						if(!textFieldIdProdutosNaAdega.getText().equals("")) {
							try {
							String query = "delete from lojaTatuape where Id='" + tableProdutosNaAdega.getValueAt(tableProdutosNaAdega.getSelectedRow(), 0) + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
							} catch (Exception g) {
								JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !"); g.printStackTrace();
							}
							refreshtableProdutosNaAdega();
	
						}else JOptionPane.showMessageDialog(null, "Selecione o Produto na tabela para deletar !", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		btnDeletarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosNaAdega.setBounds(85, 295, 113, 25);
		produtosNaAdega.add(btnDeletarProdutosNaAdega);
		
		

		JButton btnNewButtonExitProdutosNaAdega;
		btnNewButtonExitProdutosNaAdega = new JButton("");
		btnNewButtonExitProdutosNaAdega.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNaAdega.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusable(false);
		btnNewButtonExitProdutosNaAdega.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNaAdega.setFocusPainted(false);
		btnNewButtonExitProdutosNaAdega.setBorderPainted(false);
		btnNewButtonExitProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosNaAdega.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNaAdega.setContentAreaFilled(false);
		btnNewButtonExitProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitProdutosNaAdega.setBounds(0, 23, 16, 16);
		produtosNaAdega.add(btnNewButtonExitProdutosNaAdega);
		telaDeLogin.setLayout(null);

		JLabel lblGelaGuelaImageProdutosNaAdega = new JLabel("");
		lblGelaGuelaImageProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\1111111111111111111111111111111111.jpg"));
		lblGelaGuelaImageProdutosNaAdega.setBounds(-300, 11, 753, 662);
		produtosNaAdega.add(lblGelaGuelaImageProdutosNaAdega);
		
		JLabel lblNewLabel_Fundo1 = new JLabel("");
		lblNewLabel_Fundo1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\vede.jpg"));
		lblNewLabel_Fundo1.setBounds(363, 329, 439, 243);
		produtosNaAdega.add(lblNewLabel_Fundo1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\FundoDaJackApple2jpg.jpg"));
		lblNewLabel_6.setBounds(412, -66, 379, 402);
		produtosNaAdega.add(lblNewLabel_6);
		telaDeLogin.setLayout(null);
		
		textFieldUnidadesProdutosEmEstoque = new JTextField();
		textFieldUnidadesProdutosEmEstoque.setBounds(154, 145, 86, 20);
		produtosEmEstoque.add(textFieldUnidadesProdutosEmEstoque);
		textFieldUnidadesProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_UnidadesProdutoEmEstoque = new JLabel("Unidades :");
		lblNewLabel_UnidadesProdutoEmEstoque.setForeground(Color.WHITE);
		lblNewLabel_UnidadesProdutoEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_UnidadesProdutoEmEstoque.setBounds(75, 145, 69, 20);
		produtosEmEstoque.add(lblNewLabel_UnidadesProdutoEmEstoque);


		//
		//
		// ProdutosEmEstoque
		//
		//

		JMenuBar menuBarProdutosEmEstoque = new JMenuBar();
		menuBarProdutosEmEstoque.setBounds(0, 0, 934, 22);
		menuBarProdutosEmEstoque.setBackground(Color.LIGHT_GRAY);
		produtosEmEstoque.add(menuBarProdutosEmEstoque);

		JMenu mnProdutosProdutosEmEstoque = new JMenu("Produtos");
		mnProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosEmEstoque.add(mnProdutosProdutosEmEstoque);

		JMenuItem mntmProdutosNaAdegaProdutosEmEstoque = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosNaAdegaProdutosEmEstoque);

		JMenuItem mntmProdutosEmEstoqueProdutosEmEstoque = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosEmEstoqueProdutosEmEstoque);

		JMenuItem mntmProdutosParaComprarProdutosEmEstoque = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmProdutosParaComprarProdutosEmEstoque);

		JMenuItem mntmTodosProdutosProdutosEmEstoque = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosEmEstoque.add(mntmTodosProdutosProdutosEmEstoque);

		JMenu mnVenderProdutosEmEstoque = new JMenu("Vender");
		mnVenderProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosEmEstoque.add(mnVenderProdutosEmEstoque);

		JMenuItem mntmVendaVarejoProdutosEmEstoque = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaVarejoProdutosEmEstoque);

		JMenuItem mntmVendaAtacadoProdutosEmEstoque = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaAtacadoProdutosEmEstoque);

		JMenuItem mntmVendaPersonalizadaProdutosEmEstoque = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosEmEstoque.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosEmEstoque.add(mntmVendaPersonalizadaProdutosEmEstoque);
		
		JMenu mnClientesProdutosEmEstoque = new JMenu("Clientes");
		mnClientesProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosEmEstoque.add(mnClientesProdutosEmEstoque);
		
		JMenuItem mntmNewMenuItem_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosEmEstoque.add(mntmNewMenuItem_1_1);

		JMenu mnFinanceiroProdutosEmEstoque = new JMenu("Financeiro");
		mnFinanceiroProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosEmEstoque.add(mnFinanceiroProdutosEmEstoque);

		JMenu mnAjudaProdutosEmEstoque = new JMenu("Ajuda");
		mnAjudaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosEmEstoque.add(mnAjudaProdutosEmEstoque);

		JMenuItem mntmDadosDaVersaoProdutosEmEstoque = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosEmEstoque.add(mntmDadosDaVersaoProdutosEmEstoque);

		JScrollPane scrollPaneProdutosEmEstoque = new JScrollPane();
		scrollPaneProdutosEmEstoque.setBounds(270, 77, 504, 471);
		produtosEmEstoque.add(scrollPaneProdutosEmEstoque);

		tableProdutosEmEstoque = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosEmEstoque.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosEmEstoque.getSelectedRow();
				textFieldIdProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 0).toString());
				textFieldNomeProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 1).toString());
				textFieldUnidadesProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosEmEstoque.setText(tableProdutosEmEstoque.getValueAt(linha, 3).toString());
				
			}
		});
		scrollPaneProdutosEmEstoque.setViewportView(tableProdutosEmEstoque);

		JButton btnListarProdutosEmEstoque = new JButton("Mostrar Produtos no Estoque");
		btnListarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosEmEstoque();
			}
		});
		btnListarProdutosEmEstoque.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\62894-package-icon.png"));
		btnListarProdutosEmEstoque.setBounds(388, 33, 252, 33);
		produtosEmEstoque.add(btnListarProdutosEmEstoque);

		JLabel lblIdProdutosEmEstoque = new JLabel("ID do Produto : ");
		lblIdProdutosEmEstoque.setVisible(false);
		lblIdProdutosEmEstoque.setForeground(Color.WHITE);
		lblIdProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosEmEstoque.setBounds(44, 84, 97, 20);
		produtosEmEstoque.add(lblIdProdutosEmEstoque);

		JLabel lblNomeProdutosEmEstoque = new JLabel("Nome :");
		lblNomeProdutosEmEstoque.setForeground(Color.WHITE);
		lblNomeProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosEmEstoque.setBounds(85, 115, 48, 20);
		produtosEmEstoque.add(lblNomeProdutosEmEstoque);

		JLabel lblPrecoProdutosEmEstoque = new JLabel("Pre\u00E7o (UN) :");
		lblPrecoProdutosEmEstoque.setForeground(Color.WHITE);
		lblPrecoProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosEmEstoque.setBounds(72, 175, 69, 20);
		produtosEmEstoque.add(lblPrecoProdutosEmEstoque);

		textFieldIdProdutosEmEstoque = new JTextField();
		textFieldIdProdutosEmEstoque.setVisible(false);
		textFieldIdProdutosEmEstoque.setBounds(154, 85, 86, 20);
		produtosEmEstoque.add(textFieldIdProdutosEmEstoque);
		textFieldIdProdutosEmEstoque.setColumns(10);

		textFieldNomeProdutosEmEstoque = new JTextField();
		textFieldNomeProdutosEmEstoque.setBounds(154, 115, 86, 20);
		produtosEmEstoque.add(textFieldNomeProdutosEmEstoque);
		textFieldNomeProdutosEmEstoque.setColumns(10);

		textFieldPrecoProdutosEmEstoque = new JTextField();
		textFieldPrecoProdutosEmEstoque.setBounds(154, 175, 86, 20);
		produtosEmEstoque.add(textFieldPrecoProdutosEmEstoque);
		textFieldPrecoProdutosEmEstoque.setColumns(10);
		telaDeLogin.setLayout(null);

		JButton btnAdicionarProdutosEmEstoque = new JButton("Adicionar");
		btnAdicionarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
						if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
									if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
										try {
											String query = "insert into adegagelaguela.estoque (Produto, QuantidadeAtual, PrecoDeCusto) values (?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, textFieldNomeProdutosEmEstoque.getText());;
											pst.setString(2, textFieldUnidadesProdutosEmEstoque.getText());
											pst.setString(3, textFieldPrecoProdutosEmEstoque.getText());
											pst.execute();
						
											JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
						
											pst.close();
										} catch (SQLException g) {
											JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
										}
										refreshtableProdutosEmEstoque();
									}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAdicionarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosEmEstoque.setBounds(85, 225, 113, 25);
		produtosEmEstoque.add(btnAdicionarProdutosEmEstoque);

		JButton btnAtualizarProdutosEmEstoque = new JButton("Atualizar");
		btnAtualizarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if(!textFieldIdProdutosEmEstoque.getText().equals("")) {
						if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
							if(!textFieldUnidadesProdutosEmEstoque.getText().equals("")) {
										if(!textFieldPrecoProdutosEmEstoque.getText().equals("")) {
											try {
									        	if(!textFieldNomeProdutosEmEstoque.getText().equals("")) {
														String query = "Update adegagelaguela.estoque set idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ,Produto = '" + textFieldNomeProdutosEmEstoque.getText() + "' ,QuantidadeAtual = '" + textFieldUnidadesProdutosEmEstoque.getText() +"' ,PrecoDeCusto = '"+ textFieldPrecoProdutosEmEstoque.getText() + "' where idEstoque='"+ textFieldIdProdutosEmEstoque.getText() + "'  ";
														PreparedStatement pst = conexao.prepareStatement(query);  
													    pst.execute();
													    pst.close();
													    JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
													}else JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!", "ERRO!", JOptionPane.WARNING_MESSAGE);
														
												} catch (Exception g) {
													JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
												}
									        
											refreshtableProdutosEmEstoque();
										}else JOptionPane.showMessageDialog(null, "Preço vazio!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Unidades soltas vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Nome do produto vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnAtualizarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosEmEstoque.setBounds(85, 260, 113, 25);
		produtosEmEstoque.add(btnAtualizarProdutosEmEstoque);

		JButton btnDeletarProdutosEmEstoque = new JButton("Deletar");
		btnDeletarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
						if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
							if(!textFieldIdProdutosEmEstoque.getText().equals("")) {	
								try {
									String query = "delete from adegagelaguela.estoque where idEstoque='" + tableProdutosEmEstoque.getValueAt(tableProdutosEmEstoque.getSelectedRow(), 0).toString() + "' ";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.execute();
									JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
									pst.close();
								} catch (Exception g) {
									JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE); g.printStackTrace();
								}
								refreshtableProdutosEmEstoque();
							}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para excluir!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}
					}
			}
		});
		btnDeletarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosEmEstoque.setBounds(85, 295, 113, 25);
		produtosEmEstoque.add(btnDeletarProdutosEmEstoque);
		
		JButton btnNewButtonExitProdutosNoEstoque = new JButton("");
		btnNewButtonExitProdutosNoEstoque.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosNoEstoque.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusable(false);
		btnNewButtonExitProdutosNoEstoque.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosNoEstoque.setFocusPainted(false);
		btnNewButtonExitProdutosNoEstoque.setBorderPainted(false);
		btnNewButtonExitProdutosNoEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosEmEstoque.setVisible(false);
			}
		});
		btnNewButtonExitProdutosNoEstoque.setContentAreaFilled(false);
		btnNewButtonExitProdutosNoEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Actions-go-previous-icon.png"));
		btnNewButtonExitProdutosNoEstoque.setBounds(0, 23, 16, 16);
		produtosEmEstoque.add(btnNewButtonExitProdutosNoEstoque);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\minsk-bielorr\u00FAssia-de-julho-de-foto-editorial-da-garrafa-da-cerveja-de-corona-extra-no-fundo-de-madeira-uma-da-parte-superior-96219995.jpg"));
		lblNewLabel_5.setBounds(-129, -11, 1008, 621);
		produtosEmEstoque.add(lblNewLabel_5);
		telaDeLogin.setLayout(null);
		

		//
		//
		// ProdutosParaComprar
		//
		//

		JMenuBar menuBarProdutosParaComprar = new JMenuBar();
		menuBarProdutosParaComprar.setBounds(0, 0, 934, 22);
		menuBarProdutosParaComprar.setBackground(Color.LIGHT_GRAY);
		produtosParaComprar.add(menuBarProdutosParaComprar);

		JMenu mnProdutosProdutosParaComprar = new JMenu("Produtos");
		mnProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarProdutosParaComprar.add(mnProdutosProdutosParaComprar);

		JMenuItem mntmProdutosNaAdegaProdutosParaComprar = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		mntmProdutosNaAdegaProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosNaAdegaProdutosParaComprar);

		JMenuItem mntmProdutosParaComprarProdutosParaComprar = new JMenuItem("Produtos Em Estoque");
		mntmProdutosParaComprarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosParaComprarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprarProdutosParaComprar);

		JMenuItem mntmTodosProdutosProdutosParaComprar = new JMenuItem("Todos Produtos");
		mntmTodosProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});

		JMenuItem mntmProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmProdutosParaComprar);
		mntmTodosProdutosProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosProdutosParaComprar.add(mntmTodosProdutosProdutosParaComprar);

		JMenu mnVenderProdutosParaComprar = new JMenu("Vender");
		mnVenderProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarProdutosParaComprar.add(mnVenderProdutosParaComprar);

		JMenuItem mntmVendaVarejoProdutosParaComprar = new JMenuItem("Venda Varejo");
		mntmVendaVarejoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaVarejoProdutosParaComprar);

		JMenuItem mntmVendaAtacadoProdutosParaComprar = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaAtacadoProdutosParaComprar);

		JMenuItem mntmVendaPersonalizadaProdutosParaComprar = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosParaComprar.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderProdutosParaComprar.add(mntmVendaPersonalizadaProdutosParaComprar);
		
		JMenu mnClientesProdutosParaComprar = new JMenu("Clientes");
		mnClientesProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarProdutosParaComprar.add(mnClientesProdutosParaComprar);
		
		JMenuItem mntmNewMenuItem_1_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesProdutosParaComprar.add(mntmNewMenuItem_1_1_1);

		JMenu mnFinanceiroProdutosParaComprar = new JMenu("Financeiro");
		mnFinanceiroProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarProdutosParaComprar.add(mnFinanceiroProdutosParaComprar);

		JMenu mnAjudaProdutosParaComprar = new JMenu("Ajuda");
		mnAjudaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosParaComprar.add(mnAjudaProdutosParaComprar);

		JMenuItem mntmDadosDaVersaoProdutosParaComprar = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosParaComprar.add(mntmDadosDaVersaoProdutosParaComprar);

		
		JButton btnListarProdutosParaComprar = new JButton("Mostrar Lista de Compras");
		btnListarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosParaComprar();
			}
		});
		btnListarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		btnListarProdutosParaComprar.setBounds(402, 33, 252, 33);
		produtosParaComprar.add(btnListarProdutosParaComprar);

		JLabel lblIdProdutosParaComprar = new JLabel("ID para Compra : ");
		lblIdProdutosParaComprar.setVisible(false);
		lblIdProdutosParaComprar.setForeground(Color.WHITE);
		lblIdProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosParaComprar.setBounds(33, 85, 97, 20);
		produtosParaComprar.add(lblIdProdutosParaComprar);

		JLabel lblNomeProdutosParaComprar = new JLabel("Nome :");
		lblNomeProdutosParaComprar.setForeground(Color.WHITE);
		lblNomeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosParaComprar.setBounds(85, 115, 48, 20);
		produtosParaComprar.add(lblNomeProdutosParaComprar);

		JLabel lblQuantidadeProdutosParaComprar = new JLabel("Quantidade (CX) :");
		lblQuantidadeProdutosParaComprar.setForeground(Color.WHITE);
		lblQuantidadeProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeProdutosParaComprar.setBounds(27, 145, 109, 20);
		produtosParaComprar.add(lblQuantidadeProdutosParaComprar);

		JLabel lblPrecoProdutosParaComprar = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosParaComprar.setForeground(Color.WHITE);
		lblPrecoProdutosParaComprar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosParaComprar.setBounds(86, 175, 48, 20);
		produtosParaComprar.add(lblPrecoProdutosParaComprar);

		JTextField textFieldIdProdutosParaComprar = new JTextField();
		textFieldIdProdutosParaComprar.setVisible(false);
		textFieldIdProdutosParaComprar.setBounds(154, 85, 86, 20);
		produtosParaComprar.add(textFieldIdProdutosParaComprar);
		textFieldIdProdutosParaComprar.setColumns(10);

		JTextField textFieldNomeProdutosParaComprar = new JTextField();
		textFieldNomeProdutosParaComprar.setBounds(154, 115, 86, 20);
		produtosParaComprar.add(textFieldNomeProdutosParaComprar);
		textFieldNomeProdutosParaComprar.setColumns(10);

		JTextField textFieldQuantidadeProdutosParaComprar = new JTextField();
		textFieldQuantidadeProdutosParaComprar.setBounds(154, 145, 86, 20);
		produtosParaComprar.add(textFieldQuantidadeProdutosParaComprar);
		textFieldQuantidadeProdutosParaComprar.setColumns(10);

		JTextField textFieldPrecoProdutosParaComprar = new JTextField();
		textFieldPrecoProdutosParaComprar.setBounds(154, 175, 86, 20);
		produtosParaComprar.add(textFieldPrecoProdutosParaComprar);
		textFieldPrecoProdutosParaComprar.setColumns(10);
		
		JScrollPane scrollPaneProdutosParaComprar = new JScrollPane();
		scrollPaneProdutosParaComprar.setBounds(270, 77, 504, 471);
		produtosParaComprar.add(scrollPaneProdutosParaComprar);

		tableProdutosParaComprar =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
		tableProdutosParaComprar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosParaComprar.getSelectedRow();
				textFieldIdProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 0).toString());
				textFieldNomeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 1).toString());
				textFieldQuantidadeProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 2).toString());
				textFieldPrecoProdutosParaComprar.setText(tableProdutosParaComprar.getValueAt(linha, 3).toString());
			}
		});
		scrollPaneProdutosParaComprar.setViewportView(tableProdutosParaComprar);


		JButton btnAdicionarProdutosParaComprar = new JButton("Adicionar");
		btnAdicionarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					try {
						if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
							if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
								if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
									String query = "insert into produtosparacomprar ( Nome, QuantidadeUn, Preco) values (?, ?, ?)";
									PreparedStatement pst = conexao.prepareStatement(query);
									pst.setString(1, textFieldNomeProdutosParaComprar.getText());
									pst.setString(2, textFieldQuantidadeProdutosParaComprar.getText());
									pst.setString(3, textFieldPrecoProdutosParaComprar.getText());
									pst.execute();
									JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
									pst.close();
								}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Tente trocar a virgula pelo ponto!"); g.printStackTrace();
					}
				
				refreshtableProdutosParaComprar();
				}else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAdicionarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosParaComprar.setBounds(85, 225, 113, 25);
		produtosParaComprar.add(btnAdicionarProdutosParaComprar);

		JButton btnAtualizarProdutosParaComprar = new JButton("Atualizar");
		btnAtualizarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (admSenha().equals("1996")){
					try {
						if(!textFieldIdProdutosParaComprar.getText().equals("")) {
							if(!textFieldNomeProdutosParaComprar.getText().equals("")) {
								if(!textFieldQuantidadeProdutosParaComprar.getText().equals("")) {
									if(!textFieldPrecoProdutosParaComprar.getText().equals("")) {
										String query = "Update produtosparacomprar set IDParaCompra='" + textFieldIdProdutosParaComprar.getText()
												+ "' ,Nome = '" + textFieldNomeProdutosParaComprar.getText() + "' ,QuantidadeUn = '"
												+ textFieldQuantidadeProdutosParaComprar.getText() + "' ,Preco = '"
												+ textFieldPrecoProdutosParaComprar.getText() + "' where idParaCompra='"
												+ textFieldIdProdutosParaComprar.getText() + "'  ";
										PreparedStatement pst = conexao.prepareStatement(query);
										pst.execute();
										pst.close();
										JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
								
									}else JOptionPane.showMessageDialog(null, "Preço vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
								}else JOptionPane.showMessageDialog(null, "Quantidade vazia !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
							}else JOptionPane.showMessageDialog(null, "Nome vazio !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela para atualizar!!", "ERRO!", JOptionPane.WARNING_MESSAGE);		
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Tente trocar a virgula pelo ponto!!"); g.printStackTrace();
					}
					refreshtableProdutosParaComprar();
		        } else {
	        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
				}
		  }
		});
		btnAtualizarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosParaComprar.setBounds(85, 260, 113, 25);
		produtosParaComprar.add(btnAtualizarProdutosParaComprar);

		JButton btnDeletarProdutosParaComprar = new JButton("Deletar");
		btnDeletarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 if(!textFieldIdProdutosParaComprar.getText().equals("")) {
						try {
							if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
								String query = "delete from produtosparacomprar where IdParaCompra='" + tableProdutosParaComprar.getValueAt(tableProdutosParaComprar.getSelectedRow(), 0) + "'";
								PreparedStatement pst = conexao.prepareStatement(query);
								pst.execute();
								JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
								pst.close();
							}
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
						}
						refreshtableProdutosParaComprar();
					}else JOptionPane.showMessageDialog(null, "Selecione um produto da lista para deletar !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				} else {
		        		JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
					}
				}
		});
		btnDeletarProdutosParaComprar
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosParaComprar.setBounds(85, 295, 113, 25);
		produtosParaComprar.add(btnDeletarProdutosParaComprar);
		
		JButton btnNewButtonExitProdutosParaComprar;
		btnNewButtonExitProdutosParaComprar = new JButton("");
		btnNewButtonExitProdutosParaComprar.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitProdutosParaComprar.setRequestFocusEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusable(false);
		btnNewButtonExitProdutosParaComprar.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitProdutosParaComprar.setFocusPainted(false);
		btnNewButtonExitProdutosParaComprar.setBorderPainted(false);
		btnNewButtonExitProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				produtosParaComprar.setVisible(false);
			}
		});
		btnNewButtonExitProdutosParaComprar.setContentAreaFilled(false);
		btnNewButtonExitProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitProdutosParaComprar.setBounds(0, 23, 16, 16);
		produtosParaComprar.add(btnNewButtonExitProdutosParaComprar);
		telaDeLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-70, 11, 865, 555);
		produtosParaComprar.add(lblNewLabel_2);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\19_Gin-Bombay-FundoListaDeCompras.jpg"));

		

		//
		// TodosOsProdutos
		//
		//

		JMenuBar menuBarTodosOsProdutos = new JMenuBar();
		menuBarTodosOsProdutos.setBounds(0, 0, 934, 22);
		menuBarTodosOsProdutos.setBackground(Color.LIGHT_GRAY);
		todosProdutos.add(menuBarTodosOsProdutos);

		JMenu mnProdutosTodosOsProdutos = new JMenu("Produtos");
		mnProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarTodosOsProdutos.add(mnProdutosTodosOsProdutos);

		JMenuItem mntmProdutosNaAdegaTodosOsProdutos = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		mntmProdutosNaAdegaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmProdutosNaAdegaTodosOsProdutos);

		JMenuItem mntmTodosOsProdutosProdutosEmEstoque = new JMenuItem("Produtos Em Estoque");
		mntmTodosOsProdutosProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosEmEstoque);

		JMenuItem mntmTodosProdutosTodosOsProdutos = new JMenuItem("Todos Produtos");
		mntmTodosProdutosTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JMenuItem mntmTodosOsProdutosProdutosParaComprar = new JMenuItem("Produtos para Comprar");
		mntmTodosOsProdutosProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmTodosOsProdutosProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosOsProdutosProdutosParaComprar);
		mntmTodosProdutosTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosTodosOsProdutos.add(mntmTodosProdutosTodosOsProdutos);

		JMenu mnVenderTodosOsProdutos = new JMenu("Vender");
		mnVenderTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarTodosOsProdutos.add(mnVenderTodosOsProdutos);

		JMenuItem mntmVendaVarejoTodosOsProdutos = new JMenuItem("Venda Varejo");
		mntmVendaVarejoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaVarejoTodosOsProdutos);

		JMenuItem mntmVendaAtacadoTodosOsProdutos = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoTodosOsProdutos
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaAtacadoTodosOsProdutos);

		JMenuItem mntmVendaPersonalizadaTodosOsProdutos = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todosProdutos.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderTodosOsProdutos.add(mntmVendaPersonalizadaTodosOsProdutos);
		
		JMenu mnClientesTodosOsProdutos = new JMenu("Clientes");
		mnClientesTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarTodosOsProdutos.add(mnClientesTodosOsProdutos);
		
		JMenuItem mntmNewMenuItem_1_1_1_1 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesTodosOsProdutos.add(mntmNewMenuItem_1_1_1_1);

		JMenu mnFinanceiroTodosOsProdutos = new JMenu("Financeiro");
		mnFinanceiroTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarTodosOsProdutos.add(mnFinanceiroTodosOsProdutos);

		JMenu mnAjudaTodosOsProdutos = new JMenu("Ajuda");
		mnAjudaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarTodosOsProdutos.add(mnAjudaTodosOsProdutos);

		JMenuItem mntmDadosDaVersaoTodosOsProdutos = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaTodosOsProdutos.add(mntmDadosDaVersaoTodosOsProdutos);

		JScrollPane scrollPaneTodosOsProdutos = new JScrollPane();
		scrollPaneTodosOsProdutos.setBounds(270, 77, 504, 471);
		todosProdutos.add(scrollPaneTodosOsProdutos);

		

		JButton btnListarTodosOsProdutos = new JButton("Mostrar Todos os Produtos");
		btnListarTodosOsProdutos.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\listcheck.png"));
		btnListarTodosOsProdutos.setBounds(402, 33, 252, 33);
		todosProdutos.add(btnListarTodosOsProdutos);

		JLabel lblIdTodosOsProdutos = new JLabel("ID do Produto : ");
		lblIdTodosOsProdutos.setVisible(false);
		lblIdTodosOsProdutos.setBorder(null);
		lblIdTodosOsProdutos.setForeground(Color.WHITE);
		lblIdTodosOsProdutos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblIdTodosOsProdutos.setBackground(Color.WHITE);
		lblIdTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdTodosOsProdutos.setBounds(49, 85, 97, 20);
		todosProdutos.add(lblIdTodosOsProdutos);

		JLabel lblNomeTodosOsProdutos = new JLabel("Nome :");
		lblNomeTodosOsProdutos.setForeground(Color.WHITE);
		lblNomeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeTodosOsProdutos.setBounds(96, 115, 48, 20);
		todosProdutos.add(lblNomeTodosOsProdutos);

		JLabel lblQuantidadeTodosOsProdutos = new JLabel("Pre\u00E7o por Unidade :");
		lblQuantidadeTodosOsProdutos.setForeground(Color.WHITE);
		lblQuantidadeTodosOsProdutos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblQuantidadeTodosOsProdutos.setBounds(28, 145, 109, 20);
		todosProdutos.add(lblQuantidadeTodosOsProdutos);

		JTextField textFieldIdTodosOsProdutos = new JTextField();
		textFieldIdTodosOsProdutos.setVisible(false);
		textFieldIdTodosOsProdutos.setBounds(154, 85, 86, 20);
		todosProdutos.add(textFieldIdTodosOsProdutos);
		textFieldIdTodosOsProdutos.setColumns(10);

		JTextField textFieldNomeTodosOsProdutos = new JTextField();
		textFieldNomeTodosOsProdutos.setBounds(154, 115, 86, 20);
		todosProdutos.add(textFieldNomeTodosOsProdutos);
		textFieldNomeTodosOsProdutos.setColumns(10);

		JTextField textFieldQuantidadeTodosOsProdutos = new JTextField();
		textFieldQuantidadeTodosOsProdutos.setBounds(154, 145, 86, 20);
		todosProdutos.add(textFieldQuantidadeTodosOsProdutos);
		textFieldQuantidadeTodosOsProdutos.setColumns(10);

		
		JButton btnAdicionarTodosOsProdutos = new JButton("Adicionar");
		btnAdicionarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					try {
						String query = "insert into todosprodutos (Produto, PrecoUnidade) values (?, ?)";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.setString(1, textFieldNomeTodosOsProdutos.getText());
						pst.setString(2, textFieldQuantidadeTodosOsProdutos.getText());
						pst.execute();
	
						JOptionPane.showMessageDialog(null, "Salvo com sucesso !");
	
						pst.close();
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula!"); g.printStackTrace();
					}
					refreshtableTodosOsProdutos();
				}
			}
		});
		btnAdicionarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarTodosOsProdutos.setBounds(85, 225, 113, 25);
		todosProdutos.add(btnAdicionarTodosOsProdutos);

		JButton btnAtualizarTodosOsProdutos = new JButton("Atualizar");
		btnAtualizarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if (admSenha().equals("1996")){
					 try {
						 if(!textFieldIdTodosOsProdutos.getText().equals("")) {
							 
							String query = "Update todosprodutos set Id='" + textFieldIdTodosOsProdutos.getText()+ "' ,Produto = '" + textFieldNomeTodosOsProdutos.getText() + "' ,PrecoUnidade = '"+ textFieldQuantidadeTodosOsProdutos.getText() + "' where Id='"+ textFieldIdTodosOsProdutos.getText() + "'  ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							pst.close();
							JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
							
						 }else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado", "ERRO!", JOptionPane.WARNING_MESSAGE);
								
					 } catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Use ponto ao inves de virgula !"); g.printStackTrace();
					 }	
					 refreshtableTodosOsProdutos();
			    } else JOptionPane.showMessageDialog(null, "Senha Incorreta ! Tente Novamente !");
			}
		});
		btnAtualizarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarTodosOsProdutos.setBounds(85, 260, 113, 25);
		todosProdutos.add(btnAtualizarTodosOsProdutos);

		JButton btnDeletarTodosOsProdutos = new JButton("Deletar");
		btnDeletarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (admSenha().equals("1996")){
					if (JOptionPane.showConfirmDialog(null, "Deletar o Produto?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
						try {
							String query = "delete from todosprodutos where Id='"+ tableTodosProdutos.getValueAt(tableTodosProdutos.getSelectedRow(), 0) + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "ERRO !"); g.printStackTrace();
						}
						refreshtableTodosOsProdutos();
					}
				}
			}
		});
		btnDeletarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarTodosOsProdutos.setBounds(85, 295, 113, 25);
		todosProdutos.add(btnDeletarTodosOsProdutos);
		
		JButton btnNewButtonExitTodosOsProdutos;
		btnNewButtonExitTodosOsProdutos = new JButton("");
		btnNewButtonExitTodosOsProdutos.setVerifyInputWhenFocusTarget(false);
		btnNewButtonExitTodosOsProdutos.setRequestFocusEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusable(false);
		btnNewButtonExitTodosOsProdutos.setFocusTraversalKeysEnabled(false);
		btnNewButtonExitTodosOsProdutos.setFocusPainted(false);
		btnNewButtonExitTodosOsProdutos.setBorderPainted(false);
		btnNewButtonExitTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				todosProdutos.setVisible(false);
			}
		});
		btnNewButtonExitTodosOsProdutos.setContentAreaFilled(false);
		btnNewButtonExitTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Arrows-Undo-icon.png"));
		btnNewButtonExitTodosOsProdutos.setBounds(0, 23, 16, 16);
		todosProdutos.add(btnNewButtonExitTodosOsProdutos);
		telaDeLogin.setLayout(null);
		
		tableTodosProdutos =  new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	               return false;               
	        };
	        
	    };
	    tableTodosProdutos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableTodosProdutos.getSelectedRow();
				textFieldIdTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 0).toString());
				textFieldNomeTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 1).toString());
				textFieldQuantidadeTodosOsProdutos.setText(tableTodosProdutos.getValueAt(linha, 2).toString());
			}
		});
		tableTodosProdutos.setOpaque(false);
		scrollPaneTodosOsProdutos.setViewportView(tableTodosProdutos);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\e74e4d60430d27452f47f279859c921a.jpg"));
		lblNewLabel_1.setBounds(-129, 77, 435, 493);
		todosProdutos.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\52f47f279859c921a.jpg"));
		lblNewLabel.setBounds(0, 21, 782, 535);
		todosProdutos.add(lblNewLabel);
		telaDeLogin.setLayout(null);
		vendaAtacado.setLayout(null);
		
		
		
		//
		//
		//VENDA VAREJO
		//
		//
		
		JMenuBar menuBarVendaVarejo = new JMenuBar();
		menuBarVendaVarejo.setBounds(0, 0, 934, 22);
		menuBarVendaVarejo.setBackground(Color.LIGHT_GRAY);
		vendaVarejo.add(menuBarVendaVarejo);

		JMenu mnProdutosVendaVarejo = new JMenu("Produtos");
		mnProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaVarejo.add(mnProdutosVendaVarejo);

		JMenuItem mntmVendaVarejoVendaVarejo = new JMenuItem("Produtos na Adega");
		mntmVendaVarejoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosNaAdega.setVisible(true);
			}
		});
		mntmVendaVarejoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaVarejo.add(mntmVendaVarejoVendaVarejo);

		JMenuItem mntmProdutosEmEstoqueVendaVarejo = new JMenuItem("Produtos em Estoque");
		mntmProdutosEmEstoqueVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaVarejo.add(mntmProdutosEmEstoqueVendaVarejo);

		JMenuItem mntmProdutosParaComprarVendaVarejo = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaVarejo.add(mntmProdutosParaComprarVendaVarejo);

		JMenuItem mntmTodosProdutosVendaVarejo = new JMenuItem("Todos Produtos");
		mntmTodosProdutosVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		mntmTodosProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaVarejo.add(mntmTodosProdutosVendaVarejo);

		JMenu mnVenderVendaVarejo = new JMenu("Vender");
		mnVenderVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaVarejo.add(mnVenderVendaVarejo);

		JMenuItem mntmendaAtacadoVendaVarejo = new JMenuItem("Venda Varejo");
		mntmendaAtacadoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmendaAtacadoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaVarejo.add(mntmendaAtacadoVendaVarejo);

		JMenuItem mntmVendaAtacadoVendaVarejo= new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaVarejo.add(mntmVendaAtacadoVendaVarejo);

		JMenuItem mntmVendaPersonalizadaVendaVarejo = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaVarejo.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizadaVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaVarejo.add(mntmVendaPersonalizadaVendaVarejo);
		
		JMenu mnClientesVendaVarejo = new JMenu("Clientes");
		mnClientesVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaVarejo.add(mnClientesVendaVarejo);
		
		JMenuItem mntmNewMenuItem_ClienteVendaVarejo = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_ClienteVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaVarejo.add(mntmNewMenuItem_ClienteVendaVarejo);

		JMenu mnFinanceiroVendaVarejo = new JMenu("Financeiro");
		mnFinanceiroVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaVarejo.add(mnFinanceiroVendaVarejo);

		JMenu mnAjudaVendaVarejo = new JMenu("Ajuda");
		mnAjudaVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaVarejo.add(mnAjudaVendaVarejo);
		
		JScrollPane scrollPaneProdutosVendaVarejo = new JScrollPane();
		scrollPaneProdutosVendaVarejo.setBounds(322, 68, 420, 156);
		vendaVarejo.add(scrollPaneProdutosVendaVarejo);
		
		table_ProdutoVendaVarejo =  new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		table_ProdutoVendaVarejo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = table_ProdutoVendaVarejo.getSelectedRow();
				textFieldIDProdutoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 0).toString());
				textFieldProdutoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 1).toString());
				textField_PrecoVendaVarejo.setText(table_ProdutoVendaVarejo.getValueAt(linha, 3).toString());
				
			}
		});
		scrollPaneProdutosVendaVarejo.setViewportView(table_ProdutoVendaVarejo);
		
		JLabel lblNewLabel_NomeDoProdutoVendaVarejo = new JLabel("Nome do Produto : ");
		lblNewLabel_NomeDoProdutoVendaVarejo.setBounds(32, 110, 125, 20);
		vendaVarejo.add(lblNewLabel_NomeDoProdutoVendaVarejo);
		
		JLabel lblNewLabel_QuantidadeVendaVarejo = new JLabel("Quantidade (UN) :");
		lblNewLabel_QuantidadeVendaVarejo.setBounds(34, 170, 102, 20);
		vendaVarejo.add(lblNewLabel_QuantidadeVendaVarejo);
		
		JLabel lblNewLabel_PrecoProdutoVendaVarejo = new JLabel("Pre\u00E7o por unidade :");
		lblNewLabel_PrecoProdutoVendaVarejo.setBounds(32, 140, 125, 20);
		vendaVarejo.add(lblNewLabel_PrecoProdutoVendaVarejo);
		
		JButton btnNewButtonProdutosVendaVarejo = new JButton("Produtos");
		btnNewButtonProdutosVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT Id 'ID', Nome 'Nome do Produto', Unidades, Preco 'Preço por Un' FROM adegagelaguela.lojaTatuape ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					table_ProdutoVendaVarejo.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButtonProdutosVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnNewButtonProdutosVendaVarejo.setBounds(496, 34, 125, 20);
		vendaVarejo.add(btnNewButtonProdutosVendaVarejo);
		
		JLabel lblNewLabel_IDProdutoVendaVarejo = new JLabel("ID do Produto :");
		lblNewLabel_IDProdutoVendaVarejo.setBounds(32, 80, 104, 20);
		vendaVarejo.add(lblNewLabel_IDProdutoVendaVarejo);
		
		textFieldIDProdutoVendaVarejo = new JTextField();
		textFieldIDProdutoVendaVarejo.setEnabled(false);
		textFieldIDProdutoVendaVarejo.setBounds(167, 80, 113, 20);
		vendaVarejo.add(textFieldIDProdutoVendaVarejo);
		textFieldIDProdutoVendaVarejo.setColumns(10);
		
		textFieldProdutoVendaVarejo = new JTextField();
		textFieldProdutoVendaVarejo.setEditable(false);
		textFieldProdutoVendaVarejo.setBounds(167, 110, 113, 20);
		vendaVarejo.add(textFieldProdutoVendaVarejo);
		textFieldProdutoVendaVarejo.setColumns(10);
		
		textField_PrecoVendaVarejo = new JTextField();
		textField_PrecoVendaVarejo.setEditable(false);
		textField_PrecoVendaVarejo.setBounds(167, 140, 113, 20);
		vendaVarejo.add(textField_PrecoVendaVarejo);
		textField_PrecoVendaVarejo.setColumns(10);
		
		textField_QuantidadeVendaVarejo = new JTextField();
		textField_QuantidadeVendaVarejo.setBounds(167, 170, 113, 20);
		vendaVarejo.add(textField_QuantidadeVendaVarejo);
		textField_QuantidadeVendaVarejo.setColumns(10);
		
		JScrollPane scrollPane_CarrinhoVendaVarejo = new JScrollPane();
		scrollPane_CarrinhoVendaVarejo.setBounds(32, 248, 710, 131);
		vendaVarejo.add(scrollPane_CarrinhoVendaVarejo);
		
		table_CarrinhoVendaVarejo = new JTable(){
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
	    DefaultTableModel carrinhoVendaVarejo = (DefaultTableModel) table_CarrinhoVendaVarejo.getModel();
	    carrinhoVendaVarejo.addColumn("ID");
	    carrinhoVendaVarejo.addColumn("Produto");
	    carrinhoVendaVarejo.addColumn("Preço");
	    carrinhoVendaVarejo.addColumn("Quantidade");
	    carrinhoVendaVarejo.addColumn("Valor do Produto");
	    scrollPane_CarrinhoVendaVarejo.setViewportView(table_CarrinhoVendaVarejo);
		
		JButton btnNewButtonAdicionarAoCarrinhoVendaVarejo = new JButton("Adicionar ao carrinho");
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIDProdutoVendaVarejo.getText().equals("")) {
					if(!textField_QuantidadeVendaVarejo.getText().equals("") && !textField_QuantidadeVendaVarejo.getText().equals("0")&& 
							!textField_QuantidadeVendaVarejo.getText().equals("00")&& !textField_QuantidadeVendaVarejo.getText().equals("000")) {
						if(!textField_PrecoVendaVarejo.getText().equals("")) {
							 double precovenda = Double.parseDouble(textField_PrecoVendaVarejo.getText().toString());
							 double quantiavenda = Double.parseDouble(textField_QuantidadeVendaVarejo.getText().toString());
							 String total = String.valueOf(precovenda * quantiavenda);
							 
							 valorCarrinhoVarejo = valorCarrinhoVarejo+ precovenda * quantiavenda;
							 carrinhoVendaVarejo.addRow(new String [] {textFieldIDProdutoVendaVarejo.getText(), textFieldProdutoVendaVarejo.getText(), textField_PrecoVendaVarejo.getText(), textField_QuantidadeVendaVarejo.getText(), total});
							 AttValorTotalVarejo();
						}else JOptionPane.showMessageDialog(null, "Adicione o valor personalizado!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButtonAdicionarAoCarrinhoVendaVarejo.setBounds(154, 220, 158, 20);
		vendaVarejo.add(btnNewButtonAdicionarAoCarrinhoVendaVarejo);
		
	
		
		JButton btnNewButton_RemoverDoCarrinhoVendaVarejo = new JButton("Remover do carrinho");
		btnNewButton_RemoverDoCarrinhoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carrinhoVendaVarejo.removeRow(table_CarrinhoVendaVarejo.getSelectedRow());
			}
		});
		btnNewButton_RemoverDoCarrinhoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverDoCarrinhoVendaVarejo.setBounds(584, 383, 158, 20);
		vendaVarejo.add(btnNewButton_RemoverDoCarrinhoVendaVarejo);
		
		JLabel lblNewLabel_ValorTotalVendaVarejo = new JLabel("Valor Total :");
		lblNewLabel_ValorTotalVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_ValorTotalVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		lblNewLabel_ValorTotalVendaVarejo.setBounds(45, 407, 143, 24);
		vendaVarejo.add(lblNewLabel_ValorTotalVendaVarejo);
		
		
		JRadioButton rdbtnDinheiroVendaVarejo = new JRadioButton("Dinheiro");
		rdbtnDinheiroVendaVarejo.setBounds(599, 425, 109, 23);
		vendaVarejo.add(rdbtnDinheiroVendaVarejo);
		
		JRadioButton rdbtnCartaoVendaVarejo = new JRadioButton("Cart\u00E3o");
		rdbtnCartaoVendaVarejo.setBounds(599, 457, 109, 23);
		vendaVarejo.add(rdbtnCartaoVendaVarejo);
		
		textField_ValorTotalVendaVarejo = new JTextField();
		textField_ValorTotalVendaVarejo.setEditable(false);
		textField_ValorTotalVendaVarejo.setBounds(195, 410, 117, 20);
		vendaVarejo.add(textField_ValorTotalVendaVarejo);
		textField_ValorTotalVendaVarejo.setColumns(10);
		
		JButton btnNewButton_VenderVendaVarejo = new JButton("Vender");
		btnNewButton_VenderVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(null, "Venda no valor de R$: " + valorCarrinhoVarejo.toString(), "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
						int contador = 0;
						if(rdbtnDinheiroVendaVarejo.isSelected() && rdbtnCartaoVendaVarejo.isSelected()) {
							JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
							}else if(!rdbtnDinheiroVendaVarejo.isSelected() && !rdbtnCartaoVendaVarejo.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(rdbtnDinheiroVendaVarejo.isSelected()) {
									while(table_CarrinhoVendaVarejo.getRowCount() != contador) {
										try {
											String query = "INSERT INTO adegagelaguela.vendavarejo (IDProduto, Produto, Quantidade, Preco, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?)";
											PreparedStatement pst = conexao.prepareStatement(query);
											pst.setString(1, table_CarrinhoVendaVarejo.getValueAt(contador, 0).toString());
											pst.setString(2, table_CarrinhoVendaVarejo.getValueAt(contador, 1).toString());
											pst.setString(3, table_CarrinhoVendaVarejo.getValueAt(contador, 3).toString());
											pst.setString(4, table_CarrinhoVendaVarejo.getValueAt(contador, 2).toString());
											pst.setString(5, textFieldVendaVendaVarejo.getText());
											pst.setString(6, "Dinheiro");
											pst.execute();
											pst.close();
											contador++;
										} catch (Exception g) {
											g.printStackTrace();
										}
								}	
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
								
									while (carrinhoVendaVarejo.getRowCount() > 0) {
										carrinhoVendaVarejo.removeRow(carrinhoVendaVarejo.getRowCount()-1);
									}
								
									}else if(rdbtnCartaoVendaVarejo.isSelected()) {
										while(table_CarrinhoVendaVarejo.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendavarejo (IDProduto, Produto, Quantidade, Preco, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, table_CarrinhoVendaVarejo.getValueAt(contador, 0).toString());
												pst.setString(2, table_CarrinhoVendaVarejo.getValueAt(contador, 1).toString());
												pst.setString(3, table_CarrinhoVendaVarejo.getValueAt(contador, 3).toString());
												pst.setString(4, table_CarrinhoVendaVarejo.getValueAt(contador, 2).toString());
												pst.setString(5, textFieldVendaVendaVarejo.getText());
												pst.setString(6, "Cartão");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
										while (carrinhoVendaVarejo.getRowCount() > 0) {
											carrinhoVendaVarejo.removeRow(carrinhoVendaVarejo.getRowCount()-1);
										}
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
						
						}
					}
				NumeroDaVendaVarejo();
				AtualizarNumeroDaVenda();
				DocumentoVendaVarejo();
			}
		});
		btnNewButton_VenderVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		btnNewButton_VenderVendaVarejo.setBounds(647, 522, 125, 23);
		vendaVarejo.add(btnNewButton_VenderVendaVarejo);
		
		JLabel lblNewLabel_ValorPagoVendaVarejo = new JLabel("Valor Pago :");
		lblNewLabel_ValorPagoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-delete-icon.png"));
		lblNewLabel_ValorPagoVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_ValorPagoVendaVarejo.setBounds(45, 442, 143, 24);
		vendaVarejo.add(lblNewLabel_ValorPagoVendaVarejo);
		
		textField_ValorPagoVendaVarejo = new JTextField();
		textField_ValorPagoVendaVarejo.setBounds(195, 442, 117, 20);
		vendaVarejo.add(textField_ValorPagoVendaVarejo);
		textField_ValorPagoVendaVarejo.setColumns(10);
		
		JButton btnNewButton_CalcTrocoVendaVarejo = new JButton("Calcular Valor do Troco");
		btnNewButton_CalcTrocoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double troco = 0.0;
				Double valortotal = Double.parseDouble(textField_ValorTotalVendaVarejo.getText().toString());
				Double valorPago = Double.parseDouble(textField_ValorPagoVendaVarejo.getText().toString());
				troco = valorPago-valortotal;
				
				textField_TrocoVendaVarejo.setText("R$: " +troco.toString());
			}
		});
		btnNewButton_CalcTrocoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cash-register-icon.png"));
		btnNewButton_CalcTrocoVendaVarejo.setBounds(83, 478, 229, 23);
		vendaVarejo.add(btnNewButton_CalcTrocoVendaVarejo);
		
		textField_TrocoVendaVarejo = new JTextField();
		textField_TrocoVendaVarejo.setEditable(false);
		textField_TrocoVendaVarejo.setBounds(421, 445, 86, 20);
		vendaVarejo.add(textField_TrocoVendaVarejo);
		textField_TrocoVendaVarejo.setColumns(10);
		
		JLabel lblNewLabel_TrocoVendaVarejo = new JLabel("Troco :");
		lblNewLabel_TrocoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-icon.png"));
		lblNewLabel_TrocoVendaVarejo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_TrocoVendaVarejo.setBounds(421, 424, 102, 22);
		vendaVarejo.add(lblNewLabel_TrocoVendaVarejo);

		
		JLabel lblNewLabel_VendaVendaVarejo = new JLabel("Venda :");
		lblNewLabel_VendaVendaVarejo.setBounds(474, 526, 46, 20);
		vendaVarejo.add(lblNewLabel_VendaVendaVarejo);
		
		textFieldVendaVendaVarejo = new JTextField();
		textFieldVendaVendaVarejo.setEditable(false);
		textFieldVendaVendaVarejo.setBounds(530, 526, 86, 20);
		vendaVarejo.add(textFieldVendaVendaVarejo);
		textFieldVendaVendaVarejo.setColumns(10);
		textFieldVendaVendaVarejo.setText(NumeroDaVendaVarejo().toString());
		
		

		JMenuItem mntmDadosDaVersaoVendaVarejo = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaVarejo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaVarejo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));

		
		
		
		//
		//
		//VENDA ATACADO
		//
		//
		
		
		textFieldNomeDaEmpresaVendaAtacado = new JTextField();
		textFieldNomeDaEmpresaVendaAtacado.setEditable(false);
		textFieldNomeDaEmpresaVendaAtacado.setBounds(359, 452, 139, 20);
		vendaAtacado.add(textFieldNomeDaEmpresaVendaAtacado);
		textFieldNomeDaEmpresaVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_EmpresaVendaAtacado = new JLabel("Empresa :");
		lblNewLabel_EmpresaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		lblNewLabel_EmpresaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_EmpresaVendaAtacado.setBounds(272, 452, 89, 20);
		vendaAtacado.add(lblNewLabel_EmpresaVendaAtacado);

		JMenuBar menuBarVendaAtacado = new JMenuBar();
		menuBarVendaAtacado.setBounds(0, 0, 934, 22);
		menuBarVendaAtacado.setBackground(Color.LIGHT_GRAY);
		vendaAtacado.add(menuBarVendaAtacado);

		JMenu mnProdutosVendaAtacado = new JMenu("Produtos");
		mnProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaAtacado.add(mnProdutosVendaAtacado);

		JMenuItem mntmProdutosNaAdegaVendaAtacado = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaAtacado.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosNaAdegaVendaAtacado);

		JMenuItem mntmProdutosEmEstoqueVendaAtacado = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosEmEstoqueVendaAtacado);

		JMenuItem mntmTodosOsProdutosVendaAtacado;
		mntmTodosOsProdutosVendaAtacado = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				todosProdutos.setVisible(true);
			}
		});
		
				JMenuItem mntmProdutosParaComprarVendaAtacado = new JMenuItem("Produtos para Comprar");
				mntmProdutosParaComprarVendaAtacado.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						vendaAtacado.setVisible(false);
						produtosParaComprar.setVisible(true);
					}
				});
				mntmProdutosParaComprarVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
				mnProdutosVendaAtacado.add(mntmProdutosParaComprarVendaAtacado);
		mntmTodosOsProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaAtacado.add(mntmTodosOsProdutosVendaAtacado);

		JMenu mnVenderVendaAtacado = new JMenu("Vender");
		mnVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaAtacado.add(mnVenderVendaAtacado);

		JMenuItem mntmVendaVarejoVendaAtacado = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaVarejoVendaAtacado);

		JMenuItem mntmVendaPersonalizadaVendaAtacado = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizadaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		
		JMenuItem mntmVendaAtacadoVendaAtacado = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaAtacadoVendaAtacado);
		mntmVendaPersonalizadaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaAtacado.add(mntmVendaPersonalizadaVendaAtacado);
		
		JMenu mnClientesVendaAtacado = new JMenu("Clientes");
		mnClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaAtacado.add(mnClientesVendaAtacado);
		
		JMenuItem mntmNewMenuItem_1_1_1_2 = new JMenuItem("Clientes Atacado");
		mntmNewMenuItem_1_1_1_2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaAtacado.add(mntmNewMenuItem_1_1_1_2);

		JMenu mnFinanceiroVendaAtacado = new JMenu("Financeiro");
		mnFinanceiroVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaAtacado.add(mnFinanceiroVendaAtacado);

		JMenu mnAjudaVendaAtacado = new JMenu("Ajuda");
		mnAjudaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaAtacado.add(mnAjudaVendaAtacado);

		JMenuItem mntmDadosDaVersaoVendaAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaAtacado.add(mntmDadosDaVersaoVendaAtacado);

		tableClientesVendaAtacado_1 = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		tableClientesVendaAtacado_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton btnNewButton_ClientesVendaAtacado = new JButton("Clientes :");
		btnNewButton_ClientesVendaAtacado.setBounds(77, 389, 115, 23);
		btnNewButton_ClientesVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshTableClientesVendaAtacado();
			}
		});
		btnNewButton_ClientesVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ClientesVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		vendaAtacado.add(btnNewButton_ClientesVendaAtacado);
		
		JScrollPane scrollPane_ClientesVendaAtacado = new JScrollPane();
		scrollPane_ClientesVendaAtacado.setBounds(20, 423, 242, 122);
		vendaAtacado.add(scrollPane_ClientesVendaAtacado);
		
		tableClientesVendaAtacado_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableClientesVendaAtacado_1.getSelectedRow();
				txtIdDoClienteVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 0).toString());
				textFieldNomeClienteCarrinhoVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 1).toString());
				textFieldNomeDaEmpresaVendaAtacado.setText(tableClientesVendaAtacado_1.getValueAt(linha, 2).toString());
			}
		});
		scrollPane_ClientesVendaAtacado.setViewportView(tableClientesVendaAtacado_1);

		JButton btnNewButton_ProdutosVendaAtacado = new JButton("Produtos :");
		btnNewButton_ProdutosVendaAtacado.setBounds(489, 33, 115, 23);
		btnNewButton_ProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableProdutosVendaAtacado();
			}
		});
		btnNewButton_ProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-2-icon.png"));
		vendaAtacado.add(btnNewButton_ProdutosVendaAtacado);
		
		JLabel lblNewLabel_AddProdVendaAtacado = new JLabel("Venda de Produtos Atacado :");
		lblNewLabel_AddProdVendaAtacado.setBounds(75, 27, 242, 20);
		lblNewLabel_AddProdVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-icon.png"));
		lblNewLabel_AddProdVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 14));
		vendaAtacado.add(lblNewLabel_AddProdVendaAtacado);

		
		
		textFieldIdDoProdutoVendaAtacado = new JTextField();
		textFieldIdDoProdutoVendaAtacado.setVisible(false);
		textFieldIdDoProdutoVendaAtacado.setBounds(620, 37, 11, 14);
		textFieldIdDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldIdDoProdutoVendaAtacado);
		textFieldIdDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_QuantiadeUnidadeVendaAtacado = new JLabel("Quantidade por Unidades :");
		lblNewLabel_QuantiadeUnidadeVendaAtacado.setBounds(20, 140, 157, 20);
		vendaAtacado.add(lblNewLabel_QuantiadeUnidadeVendaAtacado);
		
		textField_QuantidadeUnidadeVendaAtacado = new JTextField();
		textField_QuantidadeUnidadeVendaAtacado.setBounds(172, 140, 122, 20);
		vendaAtacado.add(textField_QuantidadeUnidadeVendaAtacado);
		textField_QuantidadeUnidadeVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_ClienteVendaVendaAtacado = new JLabel("Cliente :");
		lblNewLabel_ClienteVendaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabel_ClienteVendaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_ClienteVendaVendaAtacado.setBounds(272, 421, 103, 20);
		vendaAtacado.add(lblNewLabel_ClienteVendaVendaAtacado);
		
		txtIdDoClienteVendaAtacado = new JTextField();
		txtIdDoClienteVendaAtacado.setVisible(false);
		txtIdDoClienteVendaAtacado.setBounds(0, 11, 31, 20);
		txtIdDoClienteVendaAtacado.setEditable(false);
		vendaAtacado.add(txtIdDoClienteVendaAtacado);
		txtIdDoClienteVendaAtacado.setColumns(10);
		
		JButton btnNewButton_AddCarrinhoVendaAtacado = new JButton("Adicionar  ao Carrinho");
		btnNewButton_AddCarrinhoVendaAtacado.setBounds(205, 189, 149, 23);
		btnNewButton_AddCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIdDoProdutoVendaAtacado.getText().equals("")) {
					if(!textField_QuantidadeUnidadeVendaAtacado.getText().equals("") && !textField_QuantidadeUnidadeVendaAtacado.getText().equals("0")&& 
							!textField_QuantidadeUnidadeVendaAtacado.getText().equals("00")&& !textField_QuantidadeUnidadeVendaAtacado.getText().equals("000")) {
						try {
							String query = "INSERT INTO adegagelaguela.carrinho (Estoque_idEstoque, PrecoDeVenda, QuantidadeAVender, NumeroDaVenda) VALUES (?, ?, ?, ?) ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.setString(1, textFieldIdDoProdutoVendaAtacado.getText());
							pst.setString(2, textField_PrecoParaOCarrinhoVendaAtacado.getText());
							pst.setString(3, textField_QuantidadeUnidadeVendaAtacado.getText());
							pst.setString(4, txt_NumeroDaVendaAtacado.getText());
							pst.execute();
							pst.close();
							
							JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO !", "", JOptionPane.INFORMATION_MESSAGE);
						
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
							
						}
						refreshtableCarrinhoVendaAtacado();
						refreshtableProdutosVendaAtacado();
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButton_AddCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_AddCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		vendaAtacado.add(btnNewButton_AddCarrinhoVendaAtacado);
		
		JButton btnNewButton_RemoverCarrinhoVendaAtacado = new JButton("Remover do Carrinho");
		btnNewButton_RemoverCarrinhoVendaAtacado.setBounds(364, 189, 149, 23);
		btnNewButton_RemoverCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar o Produto do carrinho?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {	
						try {
							String query = "delete from carrinho where idCarrinho='" + tableProdutosNoCarrinhoVendaAtacado.getValueAt(tableProdutosNoCarrinhoVendaAtacado.getSelectedRow(), 0).toString() + "' ";
							PreparedStatement pst = conexao.prepareStatement(query);
							pst.execute();
							JOptionPane.showMessageDialog(null, "PRODUTO REMOVIDO!", "", JOptionPane.ERROR_MESSAGE);
							pst.close();
						} catch (Exception g) {
							JOptionPane.showMessageDialog(null,"Selecione um produto da tabela abaixo !!", "ERROR!", JOptionPane.WARNING_MESSAGE); g.printStackTrace();
						}
						textFieldPrecoTotalVendaAtacado.setText("");
						refreshtableCarrinhoVendaAtacado();
						refreshtableProdutosVendaAtacado();
				}
			}
		});
		btnNewButton_RemoverCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		vendaAtacado.add(btnNewButton_RemoverCarrinhoVendaAtacado);
		

		JButton btnNewButton_LimparProdutosVendaAtacado = new JButton("Limpar Carrinho");
		btnNewButton_LimparProdutosVendaAtacado.setBounds(523, 329, 149, 23);
		btnNewButton_LimparProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deletar TODOS Produtos do carrinho?", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
					try {
						String query = "delete from carrinho where adegagelaguela.carrinho.NumeroDaVenda=?";
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.setString(1,  txt_NumeroDaVendaAtacado.getText());
						pst.execute();
						JOptionPane.showMessageDialog(null, "Carrinho Limpo!", "", JOptionPane.INFORMATION_MESSAGE);
						pst.close();
					} catch (Exception g) {
						JOptionPane.showMessageDialog(null, "ERROR!"); g.printStackTrace();
					}
					refreshtableCarrinhoVendaAtacado();
					refreshtableProdutosVendaAtacado();
					textFieldPrecoTotalVendaAtacado.setText("");
				}
			}
		});
		btnNewButton_LimparProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_LimparProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		vendaAtacado.add(btnNewButton_LimparProdutosVendaAtacado);
		
		JLabel lblNewLabel_ProdutosNoCarrinhoVendaAtacado = new JLabel("Produtos no carrinho :");
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setBounds(20, 189, 142, 20);
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		vendaAtacado.add(lblNewLabel_ProdutosNoCarrinhoVendaAtacado);
		
		JScrollPane scrollPaneCarrinhoVendaAtacado = new JScrollPane();
		scrollPaneCarrinhoVendaAtacado.setBounds(20, 220, 493, 132);
		vendaAtacado.add(scrollPaneCarrinhoVendaAtacado);
		
		tableProdutosNoCarrinhoVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		scrollPaneCarrinhoVendaAtacado.setViewportView(tableProdutosNoCarrinhoVendaAtacado);
		
		JLabel lblNewLabelNomeDoProdutoVendaAtacado = new JLabel("Nome do Produto : ");
		lblNewLabelNomeDoProdutoVendaAtacado.setBounds(20, 60, 120, 20);
		vendaAtacado.add(lblNewLabelNomeDoProdutoVendaAtacado);
		
		textField_NomeDoProdutoVendaAtacado = new JTextField();
		textField_NomeDoProdutoVendaAtacado.setBounds(137, 60, 157, 20);
		textField_NomeDoProdutoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_NomeDoProdutoVendaAtacado);
		textField_NomeDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoVendaAtacado = new JLabel("Pre\u00E7o por Unidade :");
		lblNewLabel_PrecoVendaAtacado.setBounds(20, 100, 120, 20);
		vendaAtacado.add(lblNewLabel_PrecoVendaAtacado);
		
		textField_PrecoVendaAtacado = new JTextField();
		textField_PrecoVendaAtacado.setBounds(137, 100, 157, 20);
		textField_PrecoVendaAtacado.setEditable(false);
		vendaAtacado.add(textField_PrecoVendaAtacado);
		textField_PrecoVendaAtacado.setColumns(10);
		
		JScrollPane scrollPane_ProdutosVendaAtacado = new JScrollPane();
		scrollPane_ProdutosVendaAtacado.setBounds(327, 56, 432, 122);
		vendaAtacado.add(scrollPane_ProdutosVendaAtacado);
		
		tableProdutosVendaAtacado = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	    };
		tableProdutosVendaAtacado.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosVendaAtacado.getSelectedRow();
				textFieldIdDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 0).toString());
				textField_NomeDoProdutoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 1).toString());
				textField_PrecoVendaAtacado.setText("R$ :  " + tableProdutosVendaAtacado.getValueAt(linha, 3).toString() + "0");
				textField_PrecoParaOCarrinhoVendaAtacado.setText(tableProdutosVendaAtacado.getValueAt(linha, 3).toString());
			}
		});
		scrollPane_ProdutosVendaAtacado.setViewportView(tableProdutosVendaAtacado);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(172, 189, 25, 22);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshtableCarrinhoVendaAtacado();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		vendaAtacado.add(btnNewButton_1);
		
		textFieldNomeClienteCarrinhoVendaAtacado = new JTextField();
		textFieldNomeClienteCarrinhoVendaAtacado.setEditable(false);
		textFieldNomeClienteCarrinhoVendaAtacado.setBounds(359, 421, 139, 20);
		vendaAtacado.add(textFieldNomeClienteCarrinhoVendaAtacado);
		textFieldNomeClienteCarrinhoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoTotal = new JLabel("Pre\u00E7o Total :");
		lblNewLabel_PrecoTotal.setBounds(518, 207, 163, 41);
		lblNewLabel_PrecoTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_PrecoTotal.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		vendaAtacado.add(lblNewLabel_PrecoTotal);
		
		JScrollPane scrollPanePrecoTotal = new JScrollPane();
		scrollPanePrecoTotal.setBounds(0, 31, 11, 14);
		scrollPanePrecoTotal.setVisible(false);
		vendaAtacado.add(scrollPanePrecoTotal);
		
		tablePrecoTotal = new JTable();
		scrollPanePrecoTotal.setViewportView(tablePrecoTotal);
		
		textFieldPrecoTotalVendaAtacado = new JTextField();
		textFieldPrecoTotalVendaAtacado.setBounds(642, 218, 115, 20);
		textFieldPrecoTotalVendaAtacado.setEditable(false);
		vendaAtacado.add(textFieldPrecoTotalVendaAtacado);
		textFieldPrecoTotalVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_FormaDePgmVendaAtacado = new JLabel("Forma de Pagamento :");
		lblNewLabel_FormaDePgmVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_FormaDePgmVendaAtacado.setBounds(554, 390, 201, 20);
		vendaAtacado.add(lblNewLabel_FormaDePgmVendaAtacado);
		
		
		JCheckBox chckbxAPagarVendaAtacado = new JCheckBox("Pagamento futuro");
		chckbxAPagarVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxAPagarVendaAtacado.setOpaque(false);
		chckbxAPagarVendaAtacado.setBounds(272, 489, 157, 23);
		vendaAtacado.add(chckbxAPagarVendaAtacado);
		
		JCheckBox chckbxCartaoVendaAtacado = new JCheckBox("Cart\u00E3o");
		chckbxCartaoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxCartaoVendaAtacado.setOpaque(false);
		chckbxCartaoVendaAtacado.setBounds(554, 451, 72, 23);
		vendaAtacado.add(chckbxCartaoVendaAtacado);
		
		JCheckBox chckbxDinheiroVendaAtacado = new JCheckBox("Dinheiro");
		chckbxDinheiroVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxDinheiroVendaAtacado.setOpaque(false);
		chckbxDinheiroVendaAtacado.setIcon(null);
		chckbxDinheiroVendaAtacado.setBounds(554, 420, 79, 23);
		vendaAtacado.add(chckbxDinheiroVendaAtacado);
		
		JLabel lblNewLabel_3 = new JLabel("Selecione um cliente para venda :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(20, 350, 310, 41);
		vendaAtacado.add(lblNewLabel_3);
		
		JButton btnNewButtonVenderVendaAtacado = new JButton("Vender");
		btnNewButtonVenderVendaAtacado.setBounds(614, 522, 158, 23);
		btnNewButtonVenderVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldNomeClienteCarrinhoVendaAtacado.getText().equals("")) {
					if(!chckbxAPagarVendaAtacado.isSelected()) {
						String ValorDaVenda = "Deseja finalizar a venda?\n Valor da venda " + textFieldPrecoTotalVendaAtacado.getText() + "\n Desconto de R$: " + textField_DescontoVendaAtacado.getText();
						if (JOptionPane.showConfirmDialog(null, ValorDaVenda, "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxDinheiroVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt, NumeroDaVenda, Desconto) VALUES (?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, "Dinheiro");
												pst.setString(4,  txt_NumeroDaVendaAtacado.getText());
												pst.setString(5,  textField_DescontoVendaAtacado.getText());
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									NumeroDaVendaToPDF();
									DocumentoVendaAtacado();
									refreshtableCarrinhoVendaAtacado();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										
									
										}else if(chckbxCartaoVendaAtacado.isSelected()) {
											while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt,  NumeroDaVenda, Desconto) VALUES (?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, txtIdDoClienteVendaAtacado.getText());
													pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
													pst.setString(3, "Cartão");
													pst.setString(4, txt_NumeroDaVendaAtacado.getText());
													pst.setString(5,  textField_DescontoVendaAtacado.getText());
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}	
											}	
											NumeroDaVenda();
											AtualizarNumeroDaVenda();
											NumeroDaVendaToPDF();
											DocumentoVendaAtacado();
											refreshtableCarrinhoVendaAtacado();
											JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										}
							}	
					}else if (chckbxAPagarVendaAtacado.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxDinheiroVendaAtacado.isSelected() && chckbxCartaoVendaAtacado.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxDinheiroVendaAtacado.isSelected() && !chckbxCartaoVendaAtacado.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxDinheiroVendaAtacado.isSelected()) {
										while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt, PagamentoFuturo, NumeroDaVenda, Desconto) VALUES (?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, txtIdDoClienteVendaAtacado.getText());
												pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
												pst.setString(3, "Dinheiro");
												pst.setString(4, "SIM");
												pst.setString(5, txt_NumeroDaVendaAtacado.getText());
												pst.setString(6,  textField_DescontoVendaAtacado.getText());
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									NumeroDaVendaToPDF();
									DocumentoVendaAtacado();
									refreshtableCarrinhoVendaAtacado();
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										}else if(chckbxCartaoVendaAtacado.isSelected()) {
											while(tableProdutosNoCarrinhoVendaAtacado.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.venda (Cliente_idCliente, Carrinho_idCarrinho, FormaDePgmt, PagamentoFuturo, NumeroDaVenda, Desconto) VALUES (?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, txtIdDoClienteVendaAtacado.getText());
													pst.setString(2, tableProdutosNoCarrinhoVendaAtacado.getValueAt(contador, 0).toString());
													pst.setString(3, "Cartão");
													pst.setString(4, "SIM");
													pst.setString(5, txt_NumeroDaVendaAtacado.getText());
													pst.setString(6,  textField_DescontoVendaAtacado.getText());
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}	
											}	
								NumeroDaVenda();
								AtualizarNumeroDaVenda();
								NumeroDaVendaToPDF();
								DocumentoVendaAtacado();
								refreshtableCarrinhoVendaAtacado();
								JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
							
							}
						}
					}
				}else {JOptionPane.showMessageDialog(null, "Selecione um cliente!", "", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButtonVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		vendaAtacado.add(btnNewButtonVenderVendaAtacado);
		
		JLabel lblNewLabel_4 = new JLabel("Desconto R$:");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\money-delete-icon.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(518, 259, 115, 41);
		vendaAtacado.add(lblNewLabel_4);
		
		textField_DescontoVendaAtacado = new JTextField();
		textField_DescontoVendaAtacado.setText("00.00");
		textField_DescontoVendaAtacado.setBounds(642, 270, 117, 20);
		vendaAtacado.add(textField_DescontoVendaAtacado);
		textField_DescontoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_NumeroDeVendaAtacado = new JLabel("Venda :");
		lblNewLabel_NumeroDeVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_NumeroDeVendaAtacado.setBounds(446, 523, 52, 20);
		vendaAtacado.add(lblNewLabel_NumeroDeVendaAtacado);
		
		txt_NumeroDaVendaAtacado = new JTextField();
		txt_NumeroDaVendaAtacado.setText(NumeroDaVenda().toString());
		txt_NumeroDaVendaAtacado.setEditable(false);
		txt_NumeroDaVendaAtacado.setBounds(504, 523, 86, 20);
		vendaAtacado.add(txt_NumeroDaVendaAtacado);
		txt_NumeroDaVendaAtacado.setColumns(10);
		
		textField_PrecoParaOCarrinhoVendaAtacado = new JTextField();
		textField_PrecoParaOCarrinhoVendaAtacado.setVisible(false);
		textField_PrecoParaOCarrinhoVendaAtacado.setBounds(298, 99, 19, 20);
		vendaAtacado.add(textField_PrecoParaOCarrinhoVendaAtacado);
		textField_PrecoParaOCarrinhoVendaAtacado.setColumns(10);
		
		JButton btnNewButtonVoltarMenuVendaAtacado = new JButton("");
		btnNewButtonVoltarMenuVendaAtacado.setBorderPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.setVerifyInputWhenFocusTarget(false);
		btnNewButtonVoltarMenuVendaAtacado.setRequestFocusEnabled(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusable(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusTraversalKeysEnabled(false);
		btnNewButtonVoltarMenuVendaAtacado.setFocusPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.setBorderPainted(false);
		btnNewButtonVoltarMenuVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuInicial.setVisible(true);
				vendaAtacado.setVisible(false);
			}
		});
		btnNewButtonVoltarMenuVendaAtacado.setOpaque(false);
		btnNewButtonVoltarMenuVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\Actions-go-previous-icon.png"));
		btnNewButtonVoltarMenuVendaAtacado.setBounds(0, 20, 25, 20);
		vendaAtacado.add(btnNewButtonVoltarMenuVendaAtacado);


		//
		//
		//VENDA PERSONALIZADA
		//
		//

		JMenuBar menuBarVendaPersonalizada = new JMenuBar();
		menuBarVendaPersonalizada.setBounds(0, 0, 934, 22);
		menuBarVendaPersonalizada.setBackground(Color.LIGHT_GRAY);
		vendaPersonalizada.add(menuBarVendaPersonalizada);

		JMenu mnProdutosVendaPersonalizada = new JMenu("Produtos");
		mnProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Product-sale-report-icon.png"));
		menuBarVendaPersonalizada.add(mnProdutosVendaPersonalizada);

		JMenuItem mntmProdutosNaAdegaVendaPersonalizada = new JMenuItem("Produtos na Adega");
		mntmProdutosNaAdegaVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtosNaAdega.setVisible(true);
				vendaPersonalizada.setVisible(false);
			}
		});
		mntmProdutosNaAdegaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosNaAdegaVendaPersonalizada);

		JMenuItem mntmProdutosEmEstoqueVendaPersonalizada = new JMenuItem("Produtos Em Estoque");
		mntmProdutosEmEstoqueVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosEmEstoque.setVisible(true);
			}
		});
		mntmProdutosEmEstoqueVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Cocoa-Storage-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosEmEstoqueVendaPersonalizada);

		JMenuItem mntmTodosOsProdutosVendaPersonalizada;
		mntmTodosOsProdutosVendaPersonalizada = new JMenuItem("Todos Produtos");
		mntmTodosOsProdutosVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmTodosOsProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmTodosOsProdutosVendaPersonalizada);

		JMenuItem mntmProdutosParaComprarVendaPersonalizada = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaPersonalizada.add(mntmProdutosParaComprarVendaPersonalizada);

		JMenu mnVenderVendaPersonalizada = new JMenu("Vender");
		mnVenderVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		menuBarVendaPersonalizada.add(mnVenderVendaPersonalizada);

		JMenuItem mntmVendaVarejoVendaPersonalizada = new JMenuItem("Venda Varejo");
		mntmVendaVarejoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaVarejo.setVisible(true);
			}
		});
		mntmVendaVarejoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Administrator-Blue-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaVarejoVendaPersonalizada);

		
		JMenuItem mntmVendaAtacadoVendaPersonalizada = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaAtacado.setVisible(true);
			}
		});
		mntmVendaAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaAtacadoVendaPersonalizada);
		
				JMenuItem mntmVendaPersonalizada = new JMenuItem("Venda Personalizada");
				mntmVendaPersonalizada.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				mntmVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
				mnVenderVendaPersonalizada.add(mntmVendaPersonalizada);
		
		JMenu mnClientesVendaPersonalizada = new JMenu("Clientes");
		mnClientesVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		menuBarVendaPersonalizada.add(mnClientesVendaPersonalizada);
		
		JMenuItem mntmNewMenuItemClientesAtacadoVendaPersonalizada = new JMenuItem("Clientes Atacado");
		mntmNewMenuItemClientesAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\User-Group-icon.png"));
		mnClientesVendaPersonalizada.add(mntmNewMenuItemClientesAtacadoVendaPersonalizada);
		
		JMenu mnFinanceiroVendaPersonalizada = new JMenu("Financeiro");
		mnFinanceiroVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\coins-icon (1).png"));
		menuBarVendaPersonalizada.add(mnFinanceiroVendaPersonalizada);

		JMenu mnAjudaVendaPersonalizada = new JMenu("Ajuda");
		mnAjudaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaPersonalizada.add(mnAjudaVendaPersonalizada);

		JMenuItem mntmDadosDaVersaoVendaPersonalizada = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Versão 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da versão", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaPersonalizada.add(mntmDadosDaVersaoVendaPersonalizada);
		
		JLabel lblNewLabel_EscolherProdutoVendaAtacado = new JLabel("Dados do Produto para Venda:");
		lblNewLabel_EscolherProdutoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		lblNewLabel_EscolherProdutoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_EscolherProdutoVendaAtacado.setBounds(37, 43, 256, 24);
		vendaPersonalizada.add(lblNewLabel_EscolherProdutoVendaAtacado);
		
		textFieldNomeProdutoVendaPersonalizada = new JTextField();
		textFieldNomeProdutoVendaPersonalizada.setEditable(false);
		textFieldNomeProdutoVendaPersonalizada.setBounds(179, 80, 147, 20);
		vendaPersonalizada.add(textFieldNomeProdutoVendaPersonalizada);
		textFieldNomeProdutoVendaPersonalizada.setColumns(10);
		
		textField_QuantidadeVendaPersonalizada = new JTextField();
		textField_QuantidadeVendaPersonalizada.setBounds(211, 140, 115, 20);
		vendaPersonalizada.add(textField_QuantidadeVendaPersonalizada);
		textField_QuantidadeVendaPersonalizada.setColumns(10);
		
		textField_ValorProdutoVendaPersonalizada = new JTextField();
		textField_ValorProdutoVendaPersonalizada.setEditable(false);
		textField_ValorProdutoVendaPersonalizada.setBounds(211, 110, 115, 20);
		vendaPersonalizada.add(textField_ValorProdutoVendaPersonalizada);
		textField_ValorProdutoVendaPersonalizada.setColumns(10);
		
		textField_PrecoVendaPersonalizada = new JTextField();
		textField_PrecoVendaPersonalizada.setBounds(211, 170, 115, 20);
		vendaPersonalizada.add(textField_PrecoVendaPersonalizada);
		textField_PrecoVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_NomeProdutoVendaPersonalizada = new JLabel("Nome do Produto :");
		lblNewLabel_NomeProdutoVendaPersonalizada.setBounds(37, 80, 107, 20);
		vendaPersonalizada.add(lblNewLabel_NomeProdutoVendaPersonalizada);
		
		JLabel lblNewLabel_QuantidadeParaVendaVendaPersonalizada = new JLabel("Quantidade para Venda :");
		lblNewLabel_QuantidadeParaVendaVendaPersonalizada.setBounds(37, 140, 164, 20);
		vendaPersonalizada.add(lblNewLabel_QuantidadeParaVendaVendaPersonalizada);
		
		JLabel lblNewLabel_PrecoPersVendaPersonalizada = new JLabel("Valor Pre\u00E7o Personalizado :");
		lblNewLabel_PrecoPersVendaPersonalizada.setBounds(37, 170, 178, 20);
		vendaPersonalizada.add(lblNewLabel_PrecoPersVendaPersonalizada);
		
		JLabel lblNewLabel_ValorProdutoVendaPersonalizada = new JLabel("Valor Padr\u00E3o do Produto :");
		lblNewLabel_ValorProdutoVendaPersonalizada.setBounds(37, 110, 178, 20);
		vendaPersonalizada.add(lblNewLabel_ValorProdutoVendaPersonalizada);
		
		JScrollPane scrollPaneProdutosVendaPersonalizada = new JScrollPane();
		scrollPaneProdutosVendaPersonalizada.setBounds(356, 63, 390, 172);
		vendaPersonalizada.add(scrollPaneProdutosVendaPersonalizada);
		
		tableProdutosVendaPersonalizada = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
		tableProdutosVendaPersonalizada.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int linha = tableProdutosVendaPersonalizada.getSelectedRow();
				textFieldIDVendaPersonalizada.setText(tableProdutosVendaPersonalizada.getValueAt(linha, 0).toString());
				textFieldNomeProdutoVendaPersonalizada.setText(tableProdutosVendaPersonalizada.getValueAt(linha, 1).toString());
				textField_ValorProdutoVendaPersonalizada.setText("R$ :  " + tableProdutosVendaPersonalizada.getValueAt(linha, 3).toString() + "0");
			}
		});
		scrollPaneProdutosVendaPersonalizada.setViewportView(tableProdutosVendaPersonalizada);
		
		JButton btnNewButtonProdutosVendaPersonalizada = new JButton("Produtos");
		btnNewButtonProdutosVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idEstoque 'ID', Produto, QuantidadeAtual 'Qnt disponível', PrecoDeCusto 'Preço' FROM adegagelaguela.estoque ORDER BY Produto";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosVendaPersonalizada.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButtonProdutosVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonProdutosVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnNewButtonProdutosVendaPersonalizada.setBounds(496, 32, 124, 20);
		vendaPersonalizada.add(btnNewButtonProdutosVendaPersonalizada);
		
		textFieldIDVendaPersonalizada = new JTextField();
		textFieldIDVendaPersonalizada.setVisible(false);
		textFieldIDVendaPersonalizada.setBounds(264, 58, 10, 11);
		vendaPersonalizada.add(textFieldIDVendaPersonalizada);
		textFieldIDVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_CompradorVendaAtacado = new JLabel("Dados do Comprador para Venda :");
		lblNewLabel_CompradorVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_CompradorVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\TV-Johny-Cash-icon.png"));
		lblNewLabel_CompradorVendaAtacado.setBounds(36, 240, 273, 24);
		vendaPersonalizada.add(lblNewLabel_CompradorVendaAtacado);
		
		JLabel lblNewLabel_NomeClienteVendaPersonalizada = new JLabel("Nome do Cliente :");
		lblNewLabel_NomeClienteVendaPersonalizada.setBounds(37, 275, 107, 20);
		vendaPersonalizada.add(lblNewLabel_NomeClienteVendaPersonalizada);
		
		textField_NomeClienteVendaPersonalizada = new JTextField();
		textField_NomeClienteVendaPersonalizada.setBounds(143, 275, 302, 20);
		vendaPersonalizada.add(textField_NomeClienteVendaPersonalizada);
		textField_NomeClienteVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_CPFRGVendaPersonalizada = new JLabel("CPF ou RG :");
		lblNewLabel_CPFRGVendaPersonalizada.setBounds(264, 306, 67, 20);
		vendaPersonalizada.add(lblNewLabel_CPFRGVendaPersonalizada);
		
		textField_CPFRGVendaPersonalizada = new JTextField();
		textField_CPFRGVendaPersonalizada.setBounds(330, 306, 115, 20);
		vendaPersonalizada.add(textField_CPFRGVendaPersonalizada);
		textField_CPFRGVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_EmailVendaPersonalizada = new JLabel("Email :");
		lblNewLabel_EmailVendaPersonalizada.setBounds(37, 304, 86, 20);
		vendaPersonalizada.add(lblNewLabel_EmailVendaPersonalizada);
		
		textField_EmailVendaPersonalizada = new JTextField();
		textField_EmailVendaPersonalizada.setBounds(81, 306, 164, 20);
		vendaPersonalizada.add(textField_EmailVendaPersonalizada);
		textField_EmailVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_Carrinho = new JLabel("Carrinho de Compras :");
		lblNewLabel_Carrinho.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		lblNewLabel_Carrinho.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_Carrinho.setBounds(37, 370, 178, 24);
		vendaPersonalizada.add(lblNewLabel_Carrinho);
		
		JScrollPane scrollPaneCarrinhoVendaPersonalizada = new JScrollPane();
		scrollPaneCarrinhoVendaPersonalizada.setBounds(37, 407, 433, 118);
		vendaPersonalizada.add(scrollPaneCarrinhoVendaPersonalizada);
	
		
		tableCarrinhoVendaPersonalizada = new JTable() {
	        private static final long serialVersionUID = 1L;

	        public boolean isCellEditable(int row, int column) {                
	                return false;               
	        };
	        
	    };
	    DefaultTableModel carrinhoVendaPersonalizada = (DefaultTableModel) tableCarrinhoVendaPersonalizada.getModel();
		carrinhoVendaPersonalizada.addColumn("ID");
		carrinhoVendaPersonalizada.addColumn("Produto");
		carrinhoVendaPersonalizada.addColumn("Preço");
		carrinhoVendaPersonalizada.addColumn("Quantidade");
		scrollPaneCarrinhoVendaPersonalizada.setViewportView(tableCarrinhoVendaPersonalizada);
	
		JButton btnNewButtonAddCarinhoVendaPersonalizada = new JButton("Adicionar ao Carrinho");
		btnNewButtonAddCarinhoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textFieldIDVendaPersonalizada.getText().equals("")) {
					if(!textField_QuantidadeVendaPersonalizada.getText().equals("") && !textField_QuantidadeVendaPersonalizada.getText().equals("0")&& 
							!textField_QuantidadeVendaPersonalizada.getText().equals("00")&& !textField_QuantidadeVendaPersonalizada.getText().equals("000")) {
						if(!textField_PrecoVendaPersonalizada.getText().equals("")) {
							 double precovenda = Double.parseDouble(textField_PrecoVendaPersonalizada.getText().toString());
							 double quantiavenda = Double.parseDouble(textField_QuantidadeVendaPersonalizada.getText().toString());
							 
							 valorCarrinhoPersonalizada = valorCarrinhoPersonalizada+ precovenda * quantiavenda;
							carrinhoVendaPersonalizada.addRow(new String [] {textFieldIDVendaPersonalizada.getText(), textFieldNomeProdutoVendaPersonalizada.getText(), textField_PrecoVendaPersonalizada.getText(), textField_QuantidadeVendaPersonalizada.getText()});
						}else JOptionPane.showMessageDialog(null, "Adicione o valor personalizado!!", "ERRO!", JOptionPane.WARNING_MESSAGE);
					}else JOptionPane.showMessageDialog(null, "Quantidade não pode estar vazia ou ser '0' !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				}else JOptionPane.showMessageDialog(null, "Selecione um produto da tabela ao lado !!", "ERRO!", JOptionPane.WARNING_MESSAGE);
				AttValorTotalPersonalizada();
			}
		});
		btnNewButtonAddCarinhoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButtonAddCarinhoVendaPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButtonAddCarinhoVendaPersonalizada.setBounds(179, 201, 149, 23);
		vendaPersonalizada.add(btnNewButtonAddCarinhoVendaPersonalizada);
		
		JButton btnRemoverDoCarrinhoVendaPersonalizada = new JButton("Remover do Carrinho");
		btnRemoverDoCarrinhoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carrinhoVendaPersonalizada.removeRow(tableCarrinhoVendaPersonalizada.getSelectedRow());
			}
		});
		btnRemoverDoCarrinhoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnRemoverDoCarrinhoVendaPersonalizada.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnRemoverDoCarrinhoVendaPersonalizada.setBounds(39, 525, 149, 23);
		vendaPersonalizada.add(btnRemoverDoCarrinhoVendaPersonalizada);
		
		JLabel lblNewLabel_TelefoneVendaPersonalizada = new JLabel("Telefone :");
		lblNewLabel_TelefoneVendaPersonalizada.setBounds(37, 339, 107, 20);
		vendaPersonalizada.add(lblNewLabel_TelefoneVendaPersonalizada);
		
		textField_TelefoneVendaPersonalizada = new JTextField();
		textField_TelefoneVendaPersonalizada.setBounds(102, 339, 86, 20);
		vendaPersonalizada.add(textField_TelefoneVendaPersonalizada);
		textField_TelefoneVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_EmrpesaVendaPersonalizada = new JLabel("Empresa :");
		lblNewLabel_EmrpesaVendaPersonalizada.setBounds(212, 339, 81, 20);
		vendaPersonalizada.add(lblNewLabel_EmrpesaVendaPersonalizada);
		
		textField_EmpresaVendaPersonalizada = new JTextField();
		textField_EmpresaVendaPersonalizada.setBounds(288, 341, 157, 20);
		vendaPersonalizada.add(textField_EmpresaVendaPersonalizada);
		textField_EmpresaVendaPersonalizada.setColumns(10);
		
		JLabel lblNewLabel_NumeroDeVendaPersonalizada = new JLabel("Venda :");
		lblNewLabel_NumeroDeVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_NumeroDeVendaPersonalizada.setBounds(482, 526, 52, 20);
		vendaPersonalizada.add(lblNewLabel_NumeroDeVendaPersonalizada);
		
		txt_NmrVendaVendaPersonalizada = new JTextField();
		txt_NmrVendaVendaPersonalizada.setText("a");
		txt_NmrVendaVendaPersonalizada.setEditable(false);
		txt_NmrVendaVendaPersonalizada.setColumns(10);
		txt_NmrVendaVendaPersonalizada.setBounds(534, 526, 86, 20);
		vendaPersonalizada.add(txt_NmrVendaVendaPersonalizada);
		txt_NmrVendaVendaPersonalizada.setText(NumeroDaVendaPersonalizada().toString());
		
		JLabel lblNewLabel_FormaDePagamentoVendaPersonalizada = new JLabel("Forma de Pagamento :");
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon.png"));
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_FormaDePagamentoVendaPersonalizada.setBounds(556, 241, 216, 24);
		vendaPersonalizada.add(lblNewLabel_FormaDePagamentoVendaPersonalizada);
		
		JCheckBox chckbxNewCheckBoxDinheiroVendaPersonalizada = new JCheckBox("Dinheiro");
		chckbxNewCheckBoxDinheiroVendaPersonalizada.setBounds(586, 274, 97, 23);
		vendaPersonalizada.add(chckbxNewCheckBoxDinheiroVendaPersonalizada);
		
		JCheckBox chckbxNewCheckBoxCartaoVendaPersonalizada = new JCheckBox("Cart\u00E3o");
		chckbxNewCheckBoxCartaoVendaPersonalizada.setBounds(586, 305, 97, 23);
		vendaPersonalizada.add(chckbxNewCheckBoxCartaoVendaPersonalizada);
		
		JCheckBox chckbxPagamentoFuturoVendaPersonalizada = new JCheckBox("Pagamento Futuro");
		chckbxPagamentoFuturoVendaPersonalizada.setBounds(586, 338, 135, 23);
		vendaPersonalizada.add(chckbxPagamentoFuturoVendaPersonalizada);
		
		JButton btnNewButtonVenderVendaPersonalizada = new JButton("Vender");
		btnNewButtonVenderVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_NomeClienteVendaPersonalizada.getText().equals("")){
					if(!chckbxPagamentoFuturoVendaPersonalizada.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Venda no valor de R$: " + valorCarrinhoVarejo.toString() +".00" , "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && !chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected()) {
										while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
												pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
												pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
												pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
												pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
												pst.setString(6, textField_EmailVendaPersonalizada.getText());
												pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
												pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
												pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
												pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
												pst.setString(11, "Dinheiro");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
										JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										NumeroDaVenda();
										AtualizarNumeroDaVenda();
										while (carrinhoVendaPersonalizada.getRowCount() > 0) {
											carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
										}
									
										}else if(chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
											while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
													pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
													pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
													pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
													pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
													pst.setString(6, textField_EmailVendaPersonalizada.getText());
													pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
													pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
													pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
													pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
													pst.setString(11, "Cartão");
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
										}	
											NumeroDaVenda();
											AtualizarNumeroDaVenda();
											while (carrinhoVendaPersonalizada.getRowCount() > 0) {
												carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
											}
											JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
							
							}
						}	
					}else if (chckbxPagamentoFuturoVendaPersonalizada.isSelected()) {
						if (JOptionPane.showConfirmDialog(null, "Deseja finalizar a venda?", "Confirmação de Venda", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
							int contador = 0;
							if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
								JOptionPane.showMessageDialog(null, "Selecione apenas um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
								}else if(!chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected() && !chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
									JOptionPane.showMessageDialog(null, "Selecione um metodo para pagar!", "", JOptionPane.INFORMATION_MESSAGE);
									}else if(chckbxNewCheckBoxDinheiroVendaPersonalizada.isSelected()) {
										while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
											try {
												String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento, PagamentoFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
												PreparedStatement pst = conexao.prepareStatement(query);
												pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
												pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
												pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
												pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
												pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
												pst.setString(6, textField_EmailVendaPersonalizada.getText());
												pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
												pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
												pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
												pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
												pst.setString(11, "Dinheiro");
												pst.setString(12, "Sim");
												pst.execute();
												pst.close();
												contador++;
											} catch (Exception g) {
												g.printStackTrace();
											}
									}	
									NumeroDaVenda();
									AtualizarNumeroDaVenda();
									while (carrinhoVendaPersonalizada.getRowCount() > 0) {
										carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
									}
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
										}else if(chckbxNewCheckBoxCartaoVendaPersonalizada.isSelected()) {
											while(tableCarrinhoVendaPersonalizada.getRowCount() != contador) {
												try {
													String query = "INSERT INTO adegagelaguela.vendapersonalizada (Produto_ID, NomeProduto, Preco, QuantidadeProduto, NomeCliente, Email, Telefone, Empresa, CPFouRG, NumeroDaVenda, FormaDePagamento, PagamentoFuturo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
													PreparedStatement pst = conexao.prepareStatement(query);
													pst.setString(1, tableCarrinhoVendaPersonalizada.getValueAt(contador, 0).toString());
													pst.setString(2, tableCarrinhoVendaPersonalizada.getValueAt(contador, 1).toString());
													pst.setString(3, tableCarrinhoVendaPersonalizada.getValueAt(contador, 2).toString());
													pst.setString(4, tableCarrinhoVendaPersonalizada.getValueAt(contador, 3).toString());
													pst.setString(5, textField_NomeClienteVendaPersonalizada.getText());
													pst.setString(6, textField_EmailVendaPersonalizada.getText());
													pst.setString(7, textField_TelefoneVendaPersonalizada.getText());
													pst.setString(8, textField_EmpresaVendaPersonalizada.getText());
													pst.setString(9, textField_CPFRGVendaPersonalizada.getText());
													pst.setString(10, txt_NmrVendaVendaPersonalizada.getText());
													pst.setString(11, "Cartão");
													pst.setString(12, "Sim");
													pst.execute();
													pst.close();
													contador++;
												} catch (Exception g) {
													g.printStackTrace();
												}
											}	
										AtualizarNumeroDaVenda();
										while (carrinhoVendaPersonalizada.getRowCount() > 0) {
											carrinhoVendaPersonalizada.removeRow(carrinhoVendaPersonalizada.getRowCount()-1);
										}
									JOptionPane.showMessageDialog(null, "Venda Realizada!", "", JOptionPane.INFORMATION_MESSAGE);
								}
							}
						}
				}else 
					JOptionPane.showMessageDialog(null, "Digite ao menos o nome do cliente", "Erro!!", JOptionPane.WARNING_MESSAGE);
			}
		});
		btnNewButtonVenderVendaPersonalizada.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		btnNewButtonVenderVendaPersonalizada.setBounds(631, 525, 141, 22);
		vendaPersonalizada.add(btnNewButtonVenderVendaPersonalizada);
		
		JLabel lblNewLabel_8 = new JLabel("Valor Total do Carrinho :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Coin-us-dollar-icon.png"));
		lblNewLabel_8.setBounds(480, 405, 196, 24);
		vendaPersonalizada.add(lblNewLabel_8);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setText("R$: "+ valorCarrinhoVarejo.toString() +"0");
		txtValorTotal.setBounds(496, 428, 157, 20);
		vendaPersonalizada.add(txtValorTotal);
		txtValorTotal.setColumns(10);


		//
		//
		// TELA DE LOGIN
		//
		//
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.DARK_GRAY);
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
					btnEntrar.addActionListener(new ActionListener() {
						@SuppressWarnings("deprecation")
						public void actionPerformed(ActionEvent e) {
							if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosEmEstoqueMenuInicial.setVisible(false);
								mntmProdutosParaComprarMenuInicial.setVisible(false);
								mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
								mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
								mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
								mnFinanceiroMenuInicial.setVisible(false);
								mntmVendaAtacadoMenuInicial.setVisible(false);
								mntmVendaPersonalizadaMenuInicial.setVisible(false);
								mnFinanceiroProdutosNaAdega.setVisible(false);
								mntmVendaAtacadoProdutosNaAdega.setVisible(false);
								mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
								mnFinanceiroTodosOsProdutos.setVisible(false);
								mntmVendaAtacadoTodosOsProdutos.setVisible(false);
								mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
								menuInicial.setVisible(true);
								telaDeLogin.setVisible(false);
								mntmProdutosNaAdegaMenuInicial.setVisible(false);
								btnEntrar.getRootPane().setDefaultButton(btnEntrar);
							} else {
								JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
							}

						}
					});
				}
			}
		});
		btnEntrar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-dialog-ok-apply-icon.png"));
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (checkLogin(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					mntmProdutosEmEstoqueMenuInicial.setVisible(false);
					mntmProdutosParaComprarMenuInicial.setVisible(false);
					mntmProdutosEmEstoqueProdutosNaAdega.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosEmEstoque.setVisible(false);
					mntmProdutosParaComprarProdutosNaAdega.setVisible(false);
					mntmTodosOsProdutosProdutosParaComprar.setVisible(false);
					mnFinanceiroMenuInicial.setVisible(false);
					mntmVendaAtacadoMenuInicial.setVisible(false);
					mntmVendaPersonalizadaMenuInicial.setVisible(false);
					mnFinanceiroProdutosNaAdega.setVisible(false);
					mntmVendaAtacadoProdutosNaAdega.setVisible(false);
					mntmVendaPersonalizadaProdutosNaAdega.setVisible(false);
					mnFinanceiroTodosOsProdutos.setVisible(false);
					mntmVendaAtacadoTodosOsProdutos.setVisible(false);
					mntmVendaPersonalizadaTodosOsProdutos.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
				} else if (checkLoginADM(textLogin.getText(), new String(txtSenha.getText()))) {
					menuInicial.setVisible(true);
					telaDeLogin.setVisible(false);
					btnEntrar.getRootPane().setDefaultButton(btnEntrar);
					
				} else {
					JOptionPane.showMessageDialog(null, "Dados inválidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
				}

			}
			@SuppressWarnings("unused")
			public void keyPressed(KeyEvent e) {
				btnEntrar.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setBounds(465, 221, 101, 20);
		telaDeLogin.add(btnEntrar);

		JLabel lblNewLabelLogin = new JLabel("Login");
		lblNewLabelLogin.setForeground(Color.WHITE);
		lblNewLabelLogin.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Office-Customer-Male-Light-icon.png"));
		lblNewLabelLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelLogin.setBounds(359, 150, 83, 23);
		telaDeLogin.add(lblNewLabelLogin);

		textLogin = new JTextField();
		textLogin.setSelectionColor(Color.WHITE);
		textLogin.setOpaque(false);
		textLogin.setBounds(444, 150, 145, 23);
		telaDeLogin.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabelSenha = new JLabel("Senha");
		lblNewLabelSenha.setForeground(Color.WHITE);
		lblNewLabelSenha.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\key-icon (1).png"));
		lblNewLabelSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelSenha.setBounds(359, 190, 83, 20);
		telaDeLogin.add(lblNewLabelSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setOpaque(false);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setSelectionColor(Color.WHITE);
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				txtSenha.getRootPane().setDefaultButton(btnEntrar);
			}
		});
		txtSenha.setBackground(Color.WHITE);
		txtSenha.setEchoChar('*');
		txtSenha.setColumns(10);
		txtSenha.setBounds(444, 190, 145, 20);
		telaDeLogin.add(txtSenha);

		JLabel lblNewLabelImagemDeFundo = new JLabel("");
		lblNewLabelImagemDeFundo.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Blue-Label-e1489370807665.jpg"));
		lblNewLabelImagemDeFundo.setBounds(0, -22, 789, 630);
		telaDeLogin.add(lblNewLabelImagemDeFundo);

	}

	public boolean checkLogin(String login, String senha) {
		return login.equals("user") && senha.equals("123");
	}
	public boolean checkLoginADM(String login, String senha) {
		return login.equals("1") && senha.equals("1");
	}
	
	@SuppressWarnings("deprecation")
	public String admSenha() {
		JPasswordField jpf = new JPasswordField(4);
		 jpf.setEchoChar('*');
		 JLabel jl = new JLabel("Digite a senha: ");
		 Box box = Box.createHorizontalBox();
		 box.add(jl);
		 box.add(jpf);
		JOptionPane.showConfirmDialog(null, box, "", JOptionPane.OK_CANCEL_OPTION);
		return jpf.getText().toString();
	}
	//
	//
	// RefreshTables & metodos
	//
	//
	public void refreshtableProdutosNaAdega() {
		try {
			String query = "SELECT Id 'ID', Nome 'Nome do Produto', Unidades, format(Preco,2,'de_DE') 'Preço por Un', format(PrecoTotal,2,'de_DE') 'Valor total' FROM adegagelaguela.lojaTatuape ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosNaAdega.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosEmEstoque() {
		try {
			String query = "Select idEstoque 'ID',Produto, QuantidadeAtual 'Quantidade', format(PrecoDeCusto,2,'de_DE') 'Preco Un',format(PrecoTotal,2,'de_DE') 'Valor Total' From estoque ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosEmEstoque.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}

	public void refreshtableProdutosParaComprar() {
		try {
			String query = "SELECT IDParaCompra 'ID', Nome, QuantidadeUn 'Quantidade UN', Preco 'Preço', format(ValorDeCompra,2,'de_DE') 'Total da compra' FROM adegagelaguela.produtosparacomprar ORDER BY Nome";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosParaComprar.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableTodosOsProdutos() {
		try {
			String query = "SELECT * FROM adegagelaguela.todosprodutos ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshTableClientesVendaAtacado() {
		try {
			String query = "SELECT idCliente 'ID', Nome 'Cliente', Empresa FROM adegagelaguela.cliente";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableClientesVendaAtacado_1.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();
		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableProdutosVendaAtacado() {
		try {
			String query = "SELECT idEstoque 'ID', Produto 'Nome do Produto', QuantidadeAtual 'Quantidade Disponivel', PrecoDeCusto 'Preço do Produto' FROM adegagelaguela.estoque ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));
			
			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableCarrinhoVendaAtacado() {
		try {
			String query = "SELECT adegagelaguela.carrinho.idCarrinho 'ID', adegagelaguela.estoque.Produto, adegagelaguela.carrinho.QuantidadeAVender 'Quantidade', "
					+ "format(adegagelaguela.carrinho.PrecoDeVenda ,2,'de_DE') 'Preco Unidade', format(adegagelaguela.carrinho.PrecoTotal ,2,'de_DE')'Preço Total' FROM adegagelaguela.carrinho "
					+ "JOIN adegagelaguela.estoque ON adegagelaguela.carrinho.Estoque_idEstoque = adegagelaguela.estoque.idEstoque WHERE adegagelaguela.carrinho.NumeroDaVenda = ?" ;
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1,  txt_NumeroDaVendaAtacado.getText());
			ResultSet rs = pst.executeQuery();
			tableProdutosNoCarrinhoVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

			String query2 = "SELECT format(SUM(PrecoTotal),2,'de_DE') as soma FROM adegagelaguela.carrinho WHERE NumeroDaVenda = ?";
			PreparedStatement pst2 = conexao.prepareStatement(query2);
			pst2.setString(1,  txt_NumeroDaVendaAtacado.getText());
			ResultSet rs2 = pst2.executeQuery();
			tablePrecoTotal.setModel(DbUtils.resultSetToTableModel(rs2));
			textFieldPrecoTotalVendaAtacado.setText("R$: " + tablePrecoTotal.getValueAt(0, 0).toString());
			pst.close();
			rs.close();
			pst2.close();
			rs2.close();
		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
	public void AttValorTotalPersonalizada() {
		txtValorTotal.setText("R$: "+ valorCarrinhoPersonalizada.toString());
	}
	public void AttValorTotalVarejo() {
		textField_ValorTotalVendaVarejo.setText(valorCarrinhoVarejo.toString());
	}
	
	public void AtualizarNumeroDaVenda() {
		txt_NumeroDaVendaAtacado.setText(NumeroDaVenda().toString());
		txt_NmrVendaVendaPersonalizada.setText(NumeroDaVendaPersonalizada().toString());
		textFieldVendaVendaVarejo.setText(NumeroDaVendaVarejo().toString());
	}
	public Integer NumeroDaVenda() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.carrinho ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	
	public Integer NumeroDaVendaVarejo() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendavarejo ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	public Integer NumeroDaVendaVarejoToPDF() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendavarejo ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade;
	}
	
	public Integer NumeroDaVendaPersonalizada() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.vendapersonalizada ORDER BY NumeroDaVenda DESC LIMIT 1");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade +1;
	}
	
	public Integer NumeroDaVendaToPDF() {
		int quantidade =0;
		try{
			Statement stm = conexao.createStatement(); 
			ResultSet rs = stm.executeQuery("SELECT NumeroDaVenda FROM adegagelaguela.venda ORDER BY NumeroDaVenda DESC LIMIT 1;");  
			if (rs.next()) {
				quantidade = rs.getInt(1);
			}
			
		}catch (Exception g) {
			g.printStackTrace();
		}
		return quantidade;
	}
	
	
	public void DocumentoVendaVarejo() {
		Document venda = new Document();
		String numeroDaVenda = NumeroDaVendaVarejoToPDF().toString();
		int contador =1;
		try{
			
			PdfWriter.getInstance(venda, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\VENDAS\\Venda-Varejo-" + numeroDaVenda + ".pdf"));
			venda.open();
			venda.setPageSize(PageSize.B7);
			venda.add(new Paragraph("VENDA DE NUMERO " + numeroDaVenda +" :\n"));
			
			String query =  "SELECT Produto, Quantidade, format (Preco,2,'de_DE') 'Preco' , FormaDePagamento 'Pagamento', HoraDaVenda 'Hora Venda' FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda = (?)";
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1, numeroDaVenda);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph varejo = new Paragraph("Forma de Pagamento: " +rs.getString("Pagamento")+ "\n" + "Hora da venda: "+rs.getString("Hora Venda") + "\n\n");
			venda.add(varejo);
			venda.add(new Paragraph ("\n\n"));
			
			Paragraph produto1 = new Paragraph("Produto "+ contador +" :\n"+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Preco")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+ "\n\n");
			venda.add(produto1);
			while(rs.next()){
				contador++;
				Paragraph produto =  new Paragraph("Produto "+ contador +" :\n"+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Preco")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+ "\n\n");
				venda.add(produto);
			}
			rs.close();
			pst.close();
			
			String query2 =  "SELECT format(SUM(Preco),2,'de_DE') as soma FROM adegagelaguela.vendavarejo WHERE NumeroDaVenda = (?)";
			pst = conexao.prepareStatement(query2);
			pst.setString(1, numeroDaVenda);
			rs = pst.executeQuery();
			rs.next();
			Paragraph valortotal = new Paragraph("Valor total dos produtos R$:" + rs.getString("soma"));
			rs.close();
			pst.close();
			venda.add(new Paragraph ("Total de produtos: " + contador));
			venda.add(valortotal);
			venda.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			venda.close();
		}
	}
	
	public void DocumentoVendaAtacado() {
		Document venda = new Document();
		String numeroDaVenda = NumeroDaVendaToPDF().toString();
		int contador =1;
		try{
			
			PdfWriter.getInstance(venda, new FileOutputStream("C:\\Users\\Pedro\\Desktop\\VENDAS\\Venda-Atacado-" + numeroDaVenda + ".pdf"));
			venda.open();
			venda.setPageSize(PageSize.A4);
			venda.add(new Paragraph("VENDA DE NUMERO " + numeroDaVenda +" :\n"));
			
			String query =  "SELECT cliente.Nome, cliente.Empresa, estoque.Produto 'Produto', format(carrinho.PrecoDeVenda ,2,'de_DE') 'Valor',carrinho.QuantidadeAVender 'Quantidade' , format(carrinho.PrecoTotal ,2,'de_DE') 'PreçoT', "
					+ " venda.HoraDaVenda 'Hora da Venda', venda.FormaDePgmt 'Forma de Pagamento', venda.PagamentoFuturo 'Pagamento Futuro', format(venda.Desconto ,2,'de_DE') 'Desconto' "
					+ "FROM adegagelaguela.venda JOIN adegagelaguela.cliente ON venda.Cliente_idCliente = cliente.idCliente JOIN adegagelaguela.carrinho ON venda.Carrinho_idCarrinho = carrinho.idCarrinho "
					+ "JOIN adegagelaguela.estoque ON adegagelaguela.carrinho.Estoque_idEstoque = estoque.idEstoque WHERE adegagelaguela.venda.NumeroDaVenda = (?)";
			PreparedStatement pst = conexao.prepareStatement(query);
			pst.setString(1, numeroDaVenda);
			ResultSet rs = pst.executeQuery();
			rs.next();
			Paragraph cliente = new Paragraph("Dados do cliente "+ ":\n"+"Nome: " + rs.getString("Nome") + "\n" + "Empresa: " +rs.getString("Empresa")+"\n"+"Hora da venda: " +rs.getString("Hora da Venda")+ "\n" + "Forma de Pagamento: " +rs.getString("Forma de Pagamento")+ "\n" + "Pagar no Futuro?: " 
					+rs.getString("Pagamento Futuro")+ "\n" + "Desconto de R$:" +rs.getString("Desconto") +"\n\n\n");
			venda.add(cliente);
			Paragraph produto1 = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+
					 "\n" + "Preço Total R$:" +rs.getString("PreçoT")+ "\n\n");
			venda.add(produto1);
			while(rs.next()){
				contador++;
				Paragraph produto = new Paragraph("Produto "+ contador +" :\nProduto: "+rs.getString("Produto")+ "\n" + "Valor R$:" +rs.getString("Valor")+ "\n" + "Quantidade: " +rs.getString("Quantidade")+
						 "\n" + "Preço Total R$:" +rs.getString("PreçoT")+ "\n\n");
				venda.add(produto);
				venda.add(new Paragraph ("\n\n"));
			}
			rs.close();
			pst.close();
			
			String query2 =  "SELECT format(SUM(PrecoTotal),2,'de_DE') as soma FROM adegagelaguela.carrinho WHERE NumeroDaVenda = (?)";
			pst = conexao.prepareStatement(query2);
			pst.setString(1, numeroDaVenda);
			rs = pst.executeQuery();
			rs.next();
			Paragraph valortotal = new Paragraph("Valor total dos produtos R$:" + rs.getString("soma"));
			rs.close();
			pst.close();
			venda.add(new Paragraph ("Total de produtos: " + contador));
			venda.add(valortotal);
			venda.close();
			
		}catch (DocumentException de) {
			de.printStackTrace();
		}catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			venda.close();
		}
	}
}