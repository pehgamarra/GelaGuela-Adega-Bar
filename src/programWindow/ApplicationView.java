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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import javax.swing.UIManager;

import help.Db;
import net.proteanit.sql.DbUtils;

public class ApplicationView {
	
	//Variavel do JFrame
	private JFrame frmGelaGuelaBar;
	
	//Conexao com banco de dados
	private Connection conexao;
	PreparedStatement statement;
	
	//Variaveis da tela de login
	private JTextField textLogin;
	private JPasswordField txtSenha;
	
	//Tables da se��o de Produtos
	private JTable tableProdutosNaAdega, tableProdutosParaComprar, tableProdutosEmEstoque, tableTodosProdutos;
	
	//Variaveis da Lista de Produtos na Adega
	private JTextField textFieldIdProdutosNaAdega, textFieldNomeProdutosNaAdega, textFieldQuantidadeProdutosNaAdega, textFieldPrecoProdutosNaAdega;

	//Variaveis da Lista de Estoque
	private JTextField txtUnidadeProdutosEmEstoque, textFieldCaixaProdutosEmEstoque, textFieldPrecoProdutosEmEstoque, textFieldUnidadeNaCaixa, textFieldNomeProdutosEmEstoque, textFieldIdProdutosEmEstoque;
	private JTable tableProdutosNoCarrinhoVendaAtacado;
	private JTextField textFieldNomeClienteVendaAtacado;
	private JTextField textField_CNPJVendaAtacado;
	private JTextField textField_Telefone2VendaAtacado;
	private JTextField textField_IDVendaAtacado;
	private JTextField textField_CPFVendaAtacado;
	private JTextField textField_NomeEmpresaVendaAtacado;
	private JTextField textField_TelefoneVendaAtacado;
	private JTextField txtAdmin;
	private JTextField textField_EnderecoVendaAtacado;
	private JTextField textField_NmrEnderecoVendaAtacado;
	private JTextField textField_BairroVendaAtacado;
	private JTextField textField_UFVendaAtacado;
	private JTable tableClientesVendaAtacado;
	private JTextField textFieldIdDoProdutoVendaAtacado;
	private JTextField textField_QuantidadeUnidadeVendaAtacado;
	private JTextField textField_IdDoClienteVendaAtacado;
	private JTextField textField_NomeDoProdutoVendaAtacado;
	private JTextField textField_PrecoVendaAtacado;


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
		frmGelaGuelaBar.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\gelaimages.jpg"));
		frmGelaGuelaBar.setBackground(Color.BLACK);
		frmGelaGuelaBar.setBounds(100, 100, 798, 595);
		frmGelaGuelaBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGelaGuelaBar.getContentPane().setLayout(new CardLayout(0, 0));
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
		vendaAtacado.setLayout(null);
		

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

		JMenu mnFinanceiroMenuInicial = new JMenu("Financeiro");
		mnFinanceiroMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarMenuInicial.add(mnFinanceiroMenuInicial);

		JMenu mnAjudaMenuInicial = new JMenu("Ajuda");
		mnAjudaMenuInicial.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarMenuInicial.add(mnAjudaMenuInicial);

		JMenuItem mntmDadosDaVersaoMenuInicial = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoMenuInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
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

		JMenu mnFinanceiroProdutosNaAdega = new JMenu("Financeiro");
		mnFinanceiroProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosNaAdega.add(mnFinanceiroProdutosNaAdega);

		JMenu mnAjudaProdutosNaAdega = new JMenu("Ajuda");
		mnAjudaProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosNaAdega.add(mnAjudaProdutosNaAdega);

		JMenuItem mntmDadosDaVersaoProdutosNaAdega = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosNaAdega.add(mntmDadosDaVersaoProdutosNaAdega);

		JScrollPane scrollPaneProdutosNaAdega = new JScrollPane();
		scrollPaneProdutosNaAdega.setBounds(270, 77, 504, 471);
		produtosNaAdega.add(scrollPaneProdutosNaAdega);

		tableProdutosNaAdega = new JTable();
		scrollPaneProdutosNaAdega.setViewportView(tableProdutosNaAdega);

		JButton btnListarProdutosNaAdega = new JButton("Mostrar Produtos da Adega");
		btnListarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.lojaTatuape ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosNaAdega.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosNaAdega.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Beer-And-Pretzel-icon.png"));
		btnListarProdutosNaAdega.setBounds(402, 33, 252, 33);
		produtosNaAdega.add(btnListarProdutosNaAdega);

		JLabel lblIdProdutosNaAdega = new JLabel("ID do Produto : ");
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
				try {
					String query = "insert into lojaTatuape (Id, Nome, Unidades, Preco) values (?, ?, ?, ?)";
					//String query2 = "FAZER CONFERENCIA SE O ID � IGUAL";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosNaAdega.getText());
					pst.setString(2, textFieldNomeProdutosNaAdega.getText());
					pst.setString(3, textFieldQuantidadeProdutosNaAdega.getText());
					pst.setString(4, textFieldPrecoProdutosNaAdega.getText());
					///if ( query2 == textFieldIdProdutosNaAdega.getText() ) {
						///JOptionPane.showMessageDialog(null, "O campo Id n�o pode existir");
				///	}else {
						pst.execute();
					///}
					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
			}
		});
		btnAdicionarProdutosNaAdega
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosNaAdega.setBounds(85, 225, 113, 25);
		produtosNaAdega.add(btnAdicionarProdutosNaAdega);

		JButton btnAtualizarProdutosNaAdega = new JButton("Atualizar");
		btnAtualizarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update lojaTatuape set Id='" + textFieldIdProdutosNaAdega.getText() + "' ,Nome = '"
							+ textFieldNomeProdutosNaAdega.getText() + "' ,Unidades = '"
							+ textFieldQuantidadeProdutosNaAdega.getText() + "' ,Preco = '"
							+ textFieldPrecoProdutosNaAdega.getText() + "' where Id='"
							+ textFieldIdProdutosNaAdega.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
			}
		});
		btnAtualizarProdutosNaAdega.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosNaAdega.setBounds(85, 260, 113, 25);
		produtosNaAdega.add(btnAtualizarProdutosNaAdega);

		JButton btnDeletarProdutosNaAdega = new JButton("Deletar");
		btnDeletarProdutosNaAdega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from lojaTatuape where Id='" + textFieldIdProdutosNaAdega.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosNaAdega();
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
		lblNewLabel_Fundo1.setBounds(363, 329, 419, 227);
		produtosNaAdega.add(lblNewLabel_Fundo1);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\FundoDaJackApple2jpg.jpg"));
		lblNewLabel_6.setBounds(412, -66, 379, 402);
		produtosNaAdega.add(lblNewLabel_6);
		telaDeLogin.setLayout(null);


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

		JMenu mnFinanceiroProdutosEmEstoque = new JMenu("Financeiro");
		mnFinanceiroProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosEmEstoque.add(mnFinanceiroProdutosEmEstoque);

		JMenu mnAjudaProdutosEmEstoque = new JMenu("Ajuda");
		mnAjudaProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosEmEstoque.add(mnAjudaProdutosEmEstoque);

		JMenuItem mntmDadosDaVersaoProdutosEmEstoque = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosEmEstoque.add(mntmDadosDaVersaoProdutosEmEstoque);

		JScrollPane scrollPaneProdutosEmEstoque = new JScrollPane();
		scrollPaneProdutosEmEstoque.setBounds(150, 183, 624, 365);
		produtosEmEstoque.add(scrollPaneProdutosEmEstoque);

		tableProdutosEmEstoque = new JTable();
		scrollPaneProdutosEmEstoque.setViewportView(tableProdutosEmEstoque);

		JButton btnListarProdutosEmEstoque = new JButton("Mostrar Produtos no Estoque");
		btnListarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.estoque ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosEmEstoque.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosEmEstoque.setIcon(
				new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\62894-package-icon.png"));
		btnListarProdutosEmEstoque.setBounds(325, 33, 252, 25);
		produtosEmEstoque.add(btnListarProdutosEmEstoque);

		JLabel lblIdProdutosEmEstoque = new JLabel("ID do Produto : ");
		lblIdProdutosEmEstoque.setForeground(Color.WHITE);
		lblIdProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdProdutosEmEstoque.setBounds(236, 85, 97, 20);
		produtosEmEstoque.add(lblIdProdutosEmEstoque);

		JLabel lblNomeProdutosEmEstoque = new JLabel("Nome do Produto :");
		lblNomeProdutosEmEstoque.setForeground(Color.WHITE);
		lblNomeProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNomeProdutosEmEstoque.setBounds(417, 84, 129, 20);
		produtosEmEstoque.add(lblNomeProdutosEmEstoque);

		JLabel lblPrecoProdutosEmEstoque = new JLabel("Pre\u00E7o :");
		lblPrecoProdutosEmEstoque.setForeground(Color.WHITE);
		lblPrecoProdutosEmEstoque.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrecoProdutosEmEstoque.setBounds(612, 120, 48, 20);
		produtosEmEstoque.add(lblPrecoProdutosEmEstoque);

		textFieldIdProdutosEmEstoque = new JTextField();
		textFieldIdProdutosEmEstoque.setBounds(340, 85, 40, 20);
		produtosEmEstoque.add(textFieldIdProdutosEmEstoque);
		textFieldIdProdutosEmEstoque.setColumns(10);

		textFieldNomeProdutosEmEstoque = new JTextField();
		textFieldNomeProdutosEmEstoque.setBounds(536, 86, 196, 20);
		produtosEmEstoque.add(textFieldNomeProdutosEmEstoque);
		textFieldNomeProdutosEmEstoque.setColumns(10);

		textFieldUnidadeNaCaixa = new JTextField();
		textFieldUnidadeNaCaixa.setBounds(536, 120, 40, 20);
		produtosEmEstoque.add(textFieldUnidadeNaCaixa);
		textFieldUnidadeNaCaixa.setColumns(10);

		textFieldPrecoProdutosEmEstoque = new JTextField();
		textFieldPrecoProdutosEmEstoque.setBounds(662, 120, 70, 20);
		produtosEmEstoque.add(textFieldPrecoProdutosEmEstoque);
		textFieldPrecoProdutosEmEstoque.setColumns(10);
		
		txtUnidadeProdutosEmEstoque = new JTextField();
		txtUnidadeProdutosEmEstoque.setCaretColor(Color.BLACK);
		txtUnidadeProdutosEmEstoque.setBounds(340, 120, 40, 20);
		produtosEmEstoque.add(txtUnidadeProdutosEmEstoque);
		txtUnidadeProdutosEmEstoque.setColumns(10);
		
		textFieldCaixaProdutosEmEstoque = new JTextField();
		textFieldCaixaProdutosEmEstoque.setBounds(340, 151, 40, 20);
		produtosEmEstoque.add(textFieldCaixaProdutosEmEstoque);
		textFieldCaixaProdutosEmEstoque.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Unidades soltas :");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(233, 120, 120, 20);
		produtosEmEstoque.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Quantidade de Caixas :");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(200, 151, 142, 20);
		produtosEmEstoque.add(lblNewLabel_5);
		
		JLabel lblNewLabel_7 = new JLabel("Unidades por Caixa :");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(417, 120, 113, 20);
		produtosEmEstoque.add(lblNewLabel_7);
		telaDeLogin.setLayout(null);

		JButton btnAdicionarProdutosEmEstoque = new JButton("Adicionar");
		btnAdicionarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into estoque (idEstoque, Nome, Unidade, Caixa, UnidadeNaCaixa, PrecoDeCusto) values (?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosEmEstoque.getText());
					pst.setString(2, textFieldNomeProdutosEmEstoque.getText());
					pst.setString(3, txtUnidadeProdutosEmEstoque.getText());
					pst.setString(4, textFieldCaixaProdutosEmEstoque.getText());
					pst.setString(5, textFieldUnidadeNaCaixa.getText());
					pst.setString(6, textFieldPrecoProdutosEmEstoque.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (SQLException g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosEmEstoque();
			}
		});
		btnAdicionarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosEmEstoque.setBounds(409, 150, 113, 25);
		produtosEmEstoque.add(btnAdicionarProdutosEmEstoque);

		JButton btnAtualizarProdutosEmEstoque = new JButton("Atualizar");
		btnAtualizarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update estoque set idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ,Nome = '" + textFieldNomeProdutosEmEstoque.getText() + "' ,Unidade = '" + txtUnidadeProdutosEmEstoque.getText() + "' ,Caixa = '" + textFieldCaixaProdutosEmEstoque.getText() + "' ,UnidadeNaCaixa = '" + textFieldUnidadeNaCaixa.getText() + "' ,PrecoDeCusto = '"+ textFieldPrecoProdutosEmEstoque.getText() + "' where idEstoque='"+ textFieldIdProdutosEmEstoque.getText() + "'  ";
					if(textFieldIdProdutosEmEstoque.getText() != " " ||  textFieldNomeProdutosEmEstoque.getText() != null || textFieldPrecoProdutosEmEstoque.getText() != null ||textFieldCaixaProdutosEmEstoque.getText() != null ||txtUnidadeProdutosEmEstoque.getText() != null ||textFieldUnidadeNaCaixa.getText() != null) {
						JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");
						PreparedStatement pst = conexao.prepareStatement(query);
						pst.execute();
						pst.close();
					}else
						JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); 
					
				} catch (Exception g) {
					g.printStackTrace();
					
				}
				refreshtableProdutosEmEstoque();
			}
		});
		btnAtualizarProdutosEmEstoque.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosEmEstoque.setBounds(536, 150, 113, 25);
		produtosEmEstoque.add(btnAtualizarProdutosEmEstoque);

		JButton btnDeletarProdutosEmEstoque = new JButton("Deletar");
		btnDeletarProdutosEmEstoque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from estoque where idEstoque='" + textFieldIdProdutosEmEstoque.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosEmEstoque();
			}
		});
		btnDeletarProdutosEmEstoque
				.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnDeletarProdutosEmEstoque.setBounds(662, 150, 113, 25);
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
		telaDeLogin.setLayout(null);
		
		JLabel lblNewLabel_ProdutosEmEstoqueFundo1 = new JLabel("");
		lblNewLabel_ProdutosEmEstoqueFundo1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\111111111111.jpg"));
		lblNewLabel_ProdutosEmEstoqueFundo1.setBounds(-244, 49, 545, 552);
		produtosEmEstoque.add(lblNewLabel_ProdutosEmEstoqueFundo1);
		
		JLabel lblNewLabel_ProdutosEmEstoqueFundo2 = new JLabel("");
		lblNewLabel_ProdutosEmEstoqueFundo2.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\aaaaaa.png"));
		lblNewLabel_ProdutosEmEstoqueFundo2.setBounds(0, 11, 800, 559);
		produtosEmEstoque.add(lblNewLabel_ProdutosEmEstoqueFundo2);
		

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

		JMenu mnFinanceiroProdutosParaComprar = new JMenu("Financeiro");
		mnFinanceiroProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarProdutosParaComprar.add(mnFinanceiroProdutosParaComprar);

		JMenu mnAjudaProdutosParaComprar = new JMenu("Ajuda");
		mnAjudaProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarProdutosParaComprar.add(mnAjudaProdutosParaComprar);

		JMenuItem mntmDadosDaVersaoProdutosParaComprar = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaProdutosParaComprar.add(mntmDadosDaVersaoProdutosParaComprar);

		JScrollPane scrollPaneProdutosParaComprar = new JScrollPane();
		scrollPaneProdutosParaComprar.setBounds(270, 77, 504, 471);
		produtosParaComprar.add(scrollPaneProdutosParaComprar);

		tableProdutosParaComprar = new JTable();
		scrollPaneProdutosParaComprar.setViewportView(tableProdutosParaComprar);

		JButton btnListarProdutosParaComprar = new JButton("Mostrar Lista de Compras");
		btnListarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.produtosparacomprar ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableProdutosParaComprar.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnListarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-down-icon.png"));
		btnListarProdutosParaComprar.setBounds(402, 33, 252, 33);
		produtosParaComprar.add(btnListarProdutosParaComprar);

		JLabel lblIdProdutosParaComprar = new JLabel("ID para Compra : ");
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

		JButton btnAdicionarProdutosParaComprar = new JButton("Adicionar");
		btnAdicionarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into produtosparacomprar (IdParaCompra, Nome, QuantidadeCaixa, Pre�o) values (?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdProdutosParaComprar.getText());
					pst.setString(2, textFieldNomeProdutosParaComprar.getText());
					pst.setString(3, textFieldQuantidadeProdutosParaComprar.getText());
					pst.setString(4, textFieldPrecoProdutosParaComprar.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
			}
		});
		btnAdicionarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarProdutosParaComprar.setBounds(85, 225, 113, 25);
		produtosParaComprar.add(btnAdicionarProdutosParaComprar);

		JButton btnAtualizarProdutosParaComprar = new JButton("Atualizar");
		btnAtualizarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update produtosparacomprar set IdParaCompra='" + textFieldIdProdutosParaComprar.getText()
							+ "' ,Nome = '" + textFieldNomeProdutosParaComprar.getText() + "' ,QuantidadeCaixa = '"
							+ textFieldQuantidadeProdutosParaComprar.getText() + "' ,Pre�o = '"
							+ textFieldPrecoProdutosParaComprar.getText() + "' where IdParaCompra='"
							+ textFieldIdProdutosParaComprar.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
			}
		});
		btnAtualizarProdutosParaComprar.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarProdutosParaComprar.setBounds(85, 260, 113, 25);
		produtosParaComprar.add(btnAtualizarProdutosParaComprar);

		JButton btnDeletarProdutosParaComprar = new JButton("Deletar");
		btnDeletarProdutosParaComprar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from produtosparacomprar where IdParaCompra='"
							+ textFieldIdProdutosParaComprar.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableProdutosParaComprar();
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

		JMenu mnFinanceiroTodosOsProdutos = new JMenu("Financeiro");
		mnFinanceiroTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarTodosOsProdutos.add(mnFinanceiroTodosOsProdutos);

		JMenu mnAjudaTodosOsProdutos = new JMenu("Ajuda");
		mnAjudaTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarTodosOsProdutos.add(mnAjudaTodosOsProdutos);

		JMenuItem mntmDadosDaVersaoTodosOsProdutos = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaTodosOsProdutos.add(mntmDadosDaVersaoTodosOsProdutos);

		JScrollPane scrollPaneTodosOsProdutos = new JScrollPane();
		scrollPaneTodosOsProdutos.setBounds(270, 77, 504, 471);
		todosProdutos.add(scrollPaneTodosOsProdutos);

		tableTodosProdutos = new JTable();
		tableTodosProdutos.setSelectionBackground(Color.BLACK);
		tableTodosProdutos.setSelectionForeground(Color.BLACK);
		tableTodosProdutos.setOpaque(false);
		scrollPaneTodosOsProdutos.setViewportView(tableTodosProdutos);

		JButton btnListarTodosOsProdutos = new JButton("Mostrar Todos os Produtos");
		btnListarTodosOsProdutos.setBorder(UIManager.getBorder("CheckBox.border"));
		btnListarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM gelaguela.todosprodutos ORDER BY Produto";
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
				try {
					String query = "insert into todosprodutos (Id, Produto, PrecoUnidade) values (?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdTodosOsProdutos.getText());
					pst.setString(2, textFieldNomeTodosOsProdutos.getText());
					pst.setString(3, textFieldQuantidadeTodosOsProdutos.getText());
					pst.execute();

					JOptionPane.showMessageDialog(null, "Salvo com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableTodosOsProdutos();
			}
		});
		btnAdicionarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnAdicionarTodosOsProdutos.setBounds(85, 225, 113, 25);
		todosProdutos.add(btnAdicionarTodosOsProdutos);

		JButton btnAtualizarTodosOsProdutos = new JButton("Atualizar");
		btnAtualizarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update todosprodutos set Id='" + textFieldIdTodosOsProdutos.getText()+ "' ,Produto = '" + textFieldNomeTodosOsProdutos.getText() + "' ,PrecoUnidade = '"+ textFieldQuantidadeTodosOsProdutos.getText() + "' where Id='"+ textFieldIdTodosOsProdutos.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();

					JOptionPane.showMessageDialog(null, "Atualizado com sucesso !");

					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableTodosOsProdutos();
			}
		});
		btnAtualizarTodosOsProdutos.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnAtualizarTodosOsProdutos.setBounds(85, 260, 113, 25);
		todosProdutos.add(btnAtualizarTodosOsProdutos);

		JButton btnDeletarTodosOsProdutos = new JButton("Deletar");
		btnDeletarTodosOsProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from todosprodutos where Id='"
							+ textFieldIdTodosOsProdutos.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Produto Deletado !", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableTodosOsProdutos();
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
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\e74e4d60430d27452f47f279859c921a.jpg"));
		lblNewLabel_1.setBounds(-129, 77, 435, 493);
		todosProdutos.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Pedro\\Pictures\\Camera Roll\\52f47f279859c921a.jpg"));
		lblNewLabel.setBounds(0, 21, 782, 535);
		todosProdutos.add(lblNewLabel);
		telaDeLogin.setLayout(null);
		//
		//
		//VENDA ATACADO
		//
		//

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
			}
		});
		mntmTodosOsProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\store-market-stall-icon.png"));
		mnProdutosVendaAtacado.add(mntmTodosOsProdutosVendaAtacado);

		JMenuItem mntmProdutosParaComprarVendaAtacado = new JMenuItem("Produtos para Comprar");
		mntmProdutosParaComprarVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaAtacado.setVisible(false);
				produtosParaComprar.setVisible(true);
			}
		});
		mntmProdutosParaComprarVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-cart-icon.png"));
		mnProdutosVendaAtacado.add(mntmProdutosParaComprarVendaAtacado);

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

		JMenu mnFinanceiroVendaAtacado = new JMenu("Financeiro");
		mnFinanceiroVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarVendaAtacado.add(mnFinanceiroVendaAtacado);

		JMenu mnAjudaVendaAtacado = new JMenu("Ajuda");
		mnAjudaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaAtacado.add(mnAjudaVendaAtacado);

		JMenuItem mntmDadosDaVersaoVendaAtacado = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaAtacado.add(mntmDadosDaVersaoVendaAtacado);
		
		JLabel lblNewLabel_NomeDoClienteVendaAtacado = new JLabel("Nome do Cliente :");
		lblNewLabel_NomeDoClienteVendaAtacado.setBounds(321, 50, 126, 20);
		vendaAtacado.add(lblNewLabel_NomeDoClienteVendaAtacado);
		
		textFieldNomeClienteVendaAtacado = new JTextField();
		textFieldNomeClienteVendaAtacado.setBounds(431, 50, 312, 20);
		vendaAtacado.add(textFieldNomeClienteVendaAtacado);
		textFieldNomeClienteVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_CNPJVendaAtacado = new JLabel("CNPJ :");
		lblNewLabel_CNPJVendaAtacado.setBounds(431, 90, 46, 20);
		vendaAtacado.add(lblNewLabel_CNPJVendaAtacado);
		
		textField_CNPJVendaAtacado = new JTextField();
		textField_CNPJVendaAtacado.setBounds(474, 90, 86, 20);
		vendaAtacado.add(textField_CNPJVendaAtacado);
		textField_CNPJVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_Telefone1VendaAtacado = new JLabel("Telefone (1) :");
		lblNewLabel_Telefone1VendaAtacado.setBounds(570, 90, 89, 20);
		vendaAtacado.add(lblNewLabel_Telefone1VendaAtacado);
		
		textField_Telefone2VendaAtacado = new JTextField();
		textField_Telefone2VendaAtacado.setBounds(104, 130, 89, 20);
		vendaAtacado.add(textField_Telefone2VendaAtacado);
		textField_Telefone2VendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_IdClienteVendaAtacado = new JLabel("ID do Cliente :");
		lblNewLabel_IdClienteVendaAtacado.setBounds(182, 50, 104, 20);
		vendaAtacado.add(lblNewLabel_IdClienteVendaAtacado);
		
		textField_IDVendaAtacado = new JTextField();
		textField_IDVendaAtacado.setBounds(274, 50, 37, 20);
		vendaAtacado.add(textField_IDVendaAtacado);
		textField_IDVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_CPFVendaAtacado = new JLabel("CPF :");
		lblNewLabel_CPFVendaAtacado.setBounds(26, 90, 46, 20);
		vendaAtacado.add(lblNewLabel_CPFVendaAtacado);
		
		textField_CPFVendaAtacado = new JTextField();
		textField_CPFVendaAtacado.setBounds(66, 90, 80, 20);
		vendaAtacado.add(textField_CPFVendaAtacado);
		textField_CPFVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_NomeDaEmpresaVendaAtacado = new JLabel("Nome da Empresa :");
		lblNewLabel_NomeDaEmpresaVendaAtacado.setBounds(156, 90, 112, 20);
		vendaAtacado.add(lblNewLabel_NomeDaEmpresaVendaAtacado);
		
		textField_NomeEmpresaVendaAtacado = new JTextField();
		textField_NomeEmpresaVendaAtacado.setBounds(272, 90, 149, 20);
		vendaAtacado.add(textField_NomeEmpresaVendaAtacado);
		textField_NomeEmpresaVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_Telefone2VendaAtacado = new JLabel("Telefone (2) :");
		lblNewLabel_Telefone2VendaAtacado.setBounds(26, 130, 89, 20);
		vendaAtacado.add(lblNewLabel_Telefone2VendaAtacado);
		
		textField_TelefoneVendaAtacado = new JTextField();
		textField_TelefoneVendaAtacado.setBounds(654, 90, 89, 20);
		vendaAtacado.add(textField_TelefoneVendaAtacado);
		textField_TelefoneVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_OperadorVendaAtacado = new JLabel("Operador :");
		lblNewLabel_OperadorVendaAtacado.setBounds(26, 53, 62, 14);
		vendaAtacado.add(lblNewLabel_OperadorVendaAtacado);
		
		txtAdmin = new JTextField();
		txtAdmin.setEditable(false);
		txtAdmin.setText("ADMIN");
		txtAdmin.setBounds(95, 50, 73, 20);
		vendaAtacado.add(txtAdmin);
		txtAdmin.setColumns(10);
		
		JLabel lblNewLabel_EnderecoVendaAtacado = new JLabel("Endere\u00E7o :");
		lblNewLabel_EnderecoVendaAtacado.setBounds(203, 130, 65, 20);
		vendaAtacado.add(lblNewLabel_EnderecoVendaAtacado);
		
		textField_EnderecoVendaAtacado = new JTextField();
		textField_EnderecoVendaAtacado.setBounds(270, 130, 168, 20);
		vendaAtacado.add(textField_EnderecoVendaAtacado);
		textField_EnderecoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_NmrEnderecoVendaAtacado = new JLabel("N\u00BA :");
		lblNewLabel_NmrEnderecoVendaAtacado.setBounds(448, 130, 31, 20);
		vendaAtacado.add(lblNewLabel_NmrEnderecoVendaAtacado);
		
		textField_NmrEnderecoVendaAtacado = new JTextField();
		textField_NmrEnderecoVendaAtacado.setBounds(474, 130, 31, 20);
		vendaAtacado.add(textField_NmrEnderecoVendaAtacado);
		textField_NmrEnderecoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_BairroVendaAtacado = new JLabel("Bairro :");
		lblNewLabel_BairroVendaAtacado.setBounds(515, 130, 55, 20);
		vendaAtacado.add(lblNewLabel_BairroVendaAtacado);
		
		textField_BairroVendaAtacado = new JTextField();
		textField_BairroVendaAtacado.setBounds(570, 130, 100, 20);
		vendaAtacado.add(textField_BairroVendaAtacado);
		textField_BairroVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_UFVendaAtacado = new JLabel("UF :");
		lblNewLabel_UFVendaAtacado.setBounds(680, 130, 46, 20);
		vendaAtacado.add(lblNewLabel_UFVendaAtacado);
		
		textField_UFVendaAtacado = new JTextField();
		textField_UFVendaAtacado.setBounds(706, 130, 37, 20);
		vendaAtacado.add(textField_UFVendaAtacado);
		textField_UFVendaAtacado.setColumns(10);

		tableClientesVendaAtacado = new JTable();
		
		JButton btnNewButton_ADDVendaAtacado = new JButton("Adicionar Novo Cliente");
		btnNewButton_ADDVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into clientes (ID, Cliente, CPF, Empresa, CNPJ, Telefone1, Telefone2, Endereco, Numero, Bairro, UF) "
							+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textField_IDVendaAtacado.getText());
					pst.setString(2, textFieldNomeClienteVendaAtacado.getText());
					pst.setString(3, textField_CPFVendaAtacado.getText());
					pst.setString(4, textField_NomeEmpresaVendaAtacado.getText());
					pst.setString(5, textField_CNPJVendaAtacado.getText());
					pst.setString(6, textField_TelefoneVendaAtacado.getText());
					pst.setString(7, textField_Telefone2VendaAtacado.getText());
					pst.setString(8, textField_EnderecoVendaAtacado.getText());
					pst.setString(9, textField_NmrEnderecoVendaAtacado.getText());
					pst.setString(10, textField_BairroVendaAtacado.getText());
					pst.setString(11, textField_UFVendaAtacado.getText());
				
					pst.execute();
							
					JOptionPane.showMessageDialog(null, "CLIENTE ADICIONADO !", "", JOptionPane.INFORMATION_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableClientesVendaAtacado();
			}
		});
		btnNewButton_ADDVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButton_ADDVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ADDVendaAtacado.setBounds(26, 161, 149, 25);
		vendaAtacado.add(btnNewButton_ADDVendaAtacado);
		
		JButton btnNewButton_AtualizaVendaAtacado = new JButton("Atualizar Dados");
		btnNewButton_AtualizaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "Update clientes set ID='" + textField_IDVendaAtacado.getText() 
					+ "' ,Cliente = '" + textFieldNomeClienteVendaAtacado.getText() 
					+ "' ,CPF = '" + textField_CPFVendaAtacado.getText() 
					+ "' ,Empresa = '" + textField_NomeEmpresaVendaAtacado.getText() 
					+ "' ,CNPJ = '" + textField_CNPJVendaAtacado.getText() 
					+ "' ,Telefone1 = '" + textField_TelefoneVendaAtacado.getText() 
					+ "' ,Telefone2 = '" + textField_Telefone2VendaAtacado.getText() 
					+ "' ,Endereco = '" + textField_EnderecoVendaAtacado.getText() 
					+ "' ,Numero = '" + textField_NmrEnderecoVendaAtacado.getText() 
					+ "' ,Bairro = '" + textField_BairroVendaAtacado.getText() 
					+ "' ,UF = '" + textField_UFVendaAtacado.getText() 
					+ "' where ID='"+ textField_IDVendaAtacado.getText() + "'  ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "CLIENTE ATUALIZADO !", "", JOptionPane.INFORMATION_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableClientesVendaAtacado();
			}
		});
				
		btnNewButton_AtualizaVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_AtualizaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Files-Check-File-icon.png"));
		btnNewButton_AtualizaVendaAtacado.setBounds(182, 162, 149, 23);
		vendaAtacado.add(btnNewButton_AtualizaVendaAtacado);
		
		JButton btnNewButton_DeletaVendaAtacado = new JButton("Deletar Cliente");
		btnNewButton_DeletaVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from clientes where ID='" + textField_IDVendaAtacado.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "Cliente Removido!", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "ERROR!"); g.printStackTrace();
				}
				refreshtableClientesVendaAtacado();
			}
		});
		btnNewButton_DeletaVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_DeletaVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 9));
		btnNewButton_DeletaVendaAtacado.setBounds(341, 162, 149, 23);
		vendaAtacado.add(btnNewButton_DeletaVendaAtacado);
		
		JButton btnNewButton = new JButton("Clientes :");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT ID, Cliente, Empresa FROM gelaguela.clientes";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableClientesVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-icon.png"));
		btnNewButton.setBounds(500, 162, 115, 23);
		vendaAtacado.add(btnNewButton);
		
		JScrollPane scrollPane_ClientesVendaAtacado = new JScrollPane();
		scrollPane_ClientesVendaAtacado.setBounds(413, 196, 359, 185);
		vendaAtacado.add(scrollPane_ClientesVendaAtacado);
		
		tableClientesVendaAtacado = new JTable();
		scrollPane_ClientesVendaAtacado.setViewportView(tableClientesVendaAtacado);
		
		JButton btnNewButton_ProdutosVendaAtacado = new JButton("Produtos :");
		btnNewButton_ProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT idEstoque 'ID', Nome, QuantidadeNoEstoque 'Quantidade', PrecoDeCusto 'Pre�o' FROM gelaguela.estoque ORDER BY Nome";
					PreparedStatement pst = conexao.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					tableClientesVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

					pst.close();
					rs.close();

				} catch (Exception g) {
					g.printStackTrace();
				}
			}
		});
		btnNewButton_ProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_ProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Alphabetical-Sorting-2-icon.png"));
		btnNewButton_ProdutosVendaAtacado.setBounds(625, 162, 115, 23);
		vendaAtacado.add(btnNewButton_ProdutosVendaAtacado);
		
		JLabel lblNewLabel_AddProdVendaAtacado = new JLabel("Adicionar Produtos para Venda :");
		lblNewLabel_AddProdVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_AddProdVendaAtacado.setBounds(192, 196, 211, 20);
		vendaAtacado.add(lblNewLabel_AddProdVendaAtacado);
		
		JLabel lblNewLabel_AddNovoClienteVendaAtacado = new JLabel("Adicionar Novo Cliente :");
		lblNewLabel_AddNovoClienteVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_AddNovoClienteVendaAtacado.setBounds(299, 29, 158, 20);
		vendaAtacado.add(lblNewLabel_AddNovoClienteVendaAtacado);
		
		JLabel lblNewLabel_IdDoProduto = new JLabel("ID do Produto :");
		lblNewLabel_IdDoProduto.setBounds(26, 233, 89, 20);
		vendaAtacado.add(lblNewLabel_IdDoProduto);
		
		textFieldIdDoProdutoVendaAtacado = new JTextField();
		textFieldIdDoProdutoVendaAtacado.setBounds(121, 233, 31, 20);
		vendaAtacado.add(textFieldIdDoProdutoVendaAtacado);
		textFieldIdDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_QuantiadeUnidadeVendaAtacado = new JLabel("Quantidade Unidade :");
		lblNewLabel_QuantiadeUnidadeVendaAtacado.setBounds(202, 311, 129, 20);
		vendaAtacado.add(lblNewLabel_QuantiadeUnidadeVendaAtacado);
		
		textField_QuantidadeUnidadeVendaAtacado = new JTextField();
		textField_QuantidadeUnidadeVendaAtacado.setBounds(330, 311, 73, 20);
		vendaAtacado.add(textField_QuantidadeUnidadeVendaAtacado);
		textField_QuantidadeUnidadeVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_IDDoClienteVendaVendaAtacado = new JLabel("ID do Cliente :");
		lblNewLabel_IDDoClienteVendaVendaAtacado.setBounds(170, 233, 85, 20);
		vendaAtacado.add(lblNewLabel_IDDoClienteVendaVendaAtacado);
		
		textField_IdDoClienteVendaAtacado = new JTextField();
		textField_IdDoClienteVendaAtacado.setBounds(255, 233, 31, 20);
		vendaAtacado.add(textField_IdDoClienteVendaAtacado);
		textField_IdDoClienteVendaAtacado.setColumns(10);
		
		JButton btnNewButton_AddCarrinhoVendaAtacado = new JButton("Adicionar Produto ao Carrinho");
		btnNewButton_AddCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into carrinho (IdProduto, idCliente, Produto, Quantidade, Preco) "
							+ "values (?, ?, ?, ?, ?)";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.setString(1, textFieldIdDoProdutoVendaAtacado.getText());
					pst.setString(2, textField_IdDoClienteVendaAtacado.getText());
					pst.setString(3, textField_NomeDoProdutoVendaAtacado.getText());
					pst.setString(4, textField_PrecoVendaAtacado.getText());
					pst.setString(5, textField_QuantidadeUnidadeVendaAtacado.getText());
					
					pst.execute();
							
					JOptionPane.showMessageDialog(null, "PRODUTO ADICIONADO !", "", JOptionPane.INFORMATION_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos antes de confirmar !"); g.printStackTrace();
				}
				refreshtableCarrinhoVendaAtacado();
			}
		});
		btnNewButton_AddCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_AddCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Data-Export-icon.png"));
		btnNewButton_AddCarrinhoVendaAtacado.setBounds(26, 342, 178, 23);
		vendaAtacado.add(btnNewButton_AddCarrinhoVendaAtacado);
		
		JButton btnNewButton_RemoverCarrinhoVendaAtacado = new JButton("Remover Produto do Carrinho");
		btnNewButton_RemoverCarrinhoVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "delete from carrinho where idProduto='" + textFieldIdDoProdutoVendaAtacado.getText() + "' ";
					PreparedStatement pst = conexao.prepareStatement(query);
					pst.execute();
					JOptionPane.showMessageDialog(null, "PRODUTO REMOVIDO!", "", JOptionPane.ERROR_MESSAGE);
					pst.close();
				} catch (Exception g) {
					JOptionPane.showMessageDialog(null, "ERROR!"); g.printStackTrace();
				}
				refreshtableCarrinhoVendaAtacado();
			}
		});
		btnNewButton_RemoverCarrinhoVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_RemoverCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_RemoverCarrinhoVendaAtacado.setBounds(225, 342, 178, 23);
		vendaAtacado.add(btnNewButton_RemoverCarrinhoVendaAtacado);
		

		JButton btnNewButton_LimparProdutosVendaAtacado = new JButton("Limpar Produtos\r\n");
		btnNewButton_LimparProdutosVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_LimparProdutosVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\trash-icon.png"));
		btnNewButton_LimparProdutosVendaAtacado.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNewButton_LimparProdutosVendaAtacado.setBounds(10, 522, 126, 23);
		vendaAtacado.add(btnNewButton_LimparProdutosVendaAtacado);
		
		JButton btnNewButtonVenderVendaAtacado = new JButton("Vender");
		btnNewButtonVenderVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButtonVenderVendaAtacado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonVenderVendaAtacado.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\vendas.png"));
		btnNewButtonVenderVendaAtacado.setBounds(614, 522, 158, 23);
		vendaAtacado.add(btnNewButtonVenderVendaAtacado);
		
		JLabel lblNewLabel_ProdutosNoCarrinhoVendaAtacado = new JLabel("Produtos no carrinho :");
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_ProdutosNoCarrinhoVendaAtacado.setBounds(10, 376, 142, 20);
		vendaAtacado.add(lblNewLabel_ProdutosNoCarrinhoVendaAtacado);
		
		JScrollPane scrollPaneCarrinhoVendaAtacado = new JScrollPane();
		scrollPaneCarrinhoVendaAtacado.setBounds(10, 398, 762, 113);
		vendaAtacado.add(scrollPaneCarrinhoVendaAtacado);
		
		tableProdutosNoCarrinhoVendaAtacado = new JTable();
		scrollPaneCarrinhoVendaAtacado.setViewportView(tableProdutosNoCarrinhoVendaAtacado);
		
		JLabel lblNewLabelNomeDoProdutoVendaAtacado = new JLabel("Nome do Produto : ");
		lblNewLabelNomeDoProdutoVendaAtacado.setBounds(26, 273, 120, 20);
		vendaAtacado.add(lblNewLabelNomeDoProdutoVendaAtacado);
		
		textField_NomeDoProdutoVendaAtacado = new JTextField();
		textField_NomeDoProdutoVendaAtacado.setBounds(143, 273, 211, 20);
		vendaAtacado.add(textField_NomeDoProdutoVendaAtacado);
		textField_NomeDoProdutoVendaAtacado.setColumns(10);
		
		JLabel lblNewLabel_PrecoVendaAtacado = new JLabel("Pre\u00E7o :");
		lblNewLabel_PrecoVendaAtacado.setBounds(26, 311, 59, 20);
		vendaAtacado.add(lblNewLabel_PrecoVendaAtacado);
		
		textField_PrecoVendaAtacado = new JTextField();
		textField_PrecoVendaAtacado.setBounds(78, 311, 112, 20);
		vendaAtacado.add(textField_PrecoVendaAtacado);
		textField_PrecoVendaAtacado.setColumns(10);
		
		
		JLabel lblNewLabel_FundoVendaAtacado = new JLabel("");
		lblNewLabel_FundoVendaAtacado.setBounds(0, 11, 799, 569);
		vendaAtacado.add(lblNewLabel_FundoVendaAtacado);


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

		JMenuItem mntmVendaPersonalizada = new JMenuItem("Venda Personalizada");
		mntmVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vendaPersonalizada.setVisible(false);
				vendaPersonalizada.setVisible(true);
			}
		});
		mntmVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Time-Meeting-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaPersonalizada);

		
		JMenuItem mntmVendaAtacadoVendaPersonalizada = new JMenuItem("Venda Atacado");
		mntmVendaAtacadoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mntmVendaAtacadoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\shop-icon.png"));
		mnVenderVendaPersonalizada.add(mntmVendaAtacadoVendaPersonalizada);
		
		JMenu mnFinanceiroVendaPersonalizada = new JMenu("Financeiro");
		mnFinanceiroVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\US-dollar-icon (1).png"));
		menuBarVendaPersonalizada.add(mnFinanceiroVendaPersonalizada);

		JMenu mnAjudaVendaPersonalizada = new JMenu("Ajuda");
		mnAjudaVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Actions-help-about-icon.png"));
		menuBarVendaPersonalizada.add(mnAjudaVendaPersonalizada);

		JMenuItem mntmDadosDaVersaoVendaPersonalizada = new JMenuItem("Dados da Vers\u00E3o");
		mntmDadosDaVersaoVendaPersonalizada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Vers�o 1.0.0 Beta\nContato do Desenvolvedor:\nEmail: Pedrohhouro@gmail.com\nTelefone: +55 11 992256425",
						"Dados da vers�o", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mntmDadosDaVersaoVendaPersonalizada.setIcon(new ImageIcon("C:\\Users\\Pedro\\Desktop\\gelaguela_lib\\Icones\\Help-and-Support-icon.png"));
		mnAjudaVendaPersonalizada.add(mntmDadosDaVersaoVendaPersonalizada);
		


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
								JOptionPane.showMessageDialog(null, "Dados inv�lidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
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
					JOptionPane.showMessageDialog(null, "Dados inv�lidos!", "ERRO!!", JOptionPane.ERROR_MESSAGE);
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

	// RefreshTables
	public void refreshtableProdutosNaAdega() {
		try {
			String query = "SELECT * FROM gelaguela.lojaTatuape ORDER BY Nome";
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
			String query = "SELECT * FROM gelaguela.estoque ORDER BY Nome";
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
			String query = "SELECT Nome, QuantidadeCaixa 'Quantidade de Caixas', Pre�o, ValorCompra, 'Valor total' FROM gelaguela.produtosparacomprar ORDER BY Nome";
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
			String query = "SELECT * FROM gelaguela.todosprodutos ORDER BY Produto";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableTodosProdutos.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableClientesVendaAtacado() {
		try {
			String query = "SELECT ID, Cliente, Empresa FROM gelaguela.clientes";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableClientesVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	public void refreshtableCarrinhoVendaAtacado() {
		try {
			String query = "SELECT estoque.Nome, carrinho.Quantidade, carrinho.Preco, carrinho.PrecoTotal from gelaguela.carrinho join estoque on carrinho.IdProduto = estoque.idEstoque";
			PreparedStatement pst = conexao.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			tableProdutosNoCarrinhoVendaAtacado.setModel(DbUtils.resultSetToTableModel(rs));

			pst.close();
			rs.close();

		} catch (Exception g) {
			g.printStackTrace();
		}
	}
	
}