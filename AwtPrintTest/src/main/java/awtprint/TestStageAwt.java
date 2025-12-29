package awtprint;



import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.attribute.HashPrintRequestAttributeSet;

@SuppressWarnings("serial")
public class TestStageAwt extends Frame
{
	public TestStageAwt()
	{
		setLayout( new GridBagLayout());
		setTitle("Awt Print Test");
		add( new RootNode());
		pack();
		setVisible(true);
		addWindowListener( new Closer());
	}
	private class Closer extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e)
		{
			dispose();
			setVisible(false);
			System.exit(0);
		}
	}
	private class RootNode extends Panel
	{
		RootNode()
		{
			add( new Label( PrinterJob.getPrinterJob().getJobName()));

			Button print = new Button("print");
			add( print);
			print.addActionListener( TestStageAwt.this::print);

			Button pss = new Button("Page Setup");
			add( pss);
			pss.addActionListener(TestStageAwt.this::showPageSetup);

			{
				Button b = new Button("Print Dialog");
				add( b);
				b.addActionListener( TestStageAwt.this::showPrintDialog);
				
			}
			add( new PageLayoutView());
			add( new PrinterAttributeView());
		}
	}
    private void print(final ActionEvent event) 
    {
    	PrinterJob printerJob = PrinterJob.getPrinterJob();
    	printerJob.setPrintable( new DemoPage());
    	try
		{
			printerJob.print();
		} catch (PrinterException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    private void showPageSetup(final ActionEvent event) {
    	PrinterJob.getPrinterJob().pageDialog( new HashPrintRequestAttributeSet() );
    }
    private void showPrintDialog(final ActionEvent event) {
    	PrinterJob.getPrinterJob().printDialog();
    }
    private class PageLayoutView extends TextArea
    {
    	PageLayoutView()
    	{
    		setEditable(false);
    		append("PageLayout\n");
    		PageFormat pageFormat = PrinterJob.getPrinterJob().defaultPage();
    		append("Height " + pageFormat.getHeight() + "\n");
    		append("ImageableHeight " + pageFormat.getImageableHeight() + "\n");
    		append("ImageableWidth " + pageFormat.getImageableWidth() + "\n");
    		append("ImageableX " + pageFormat.getImageableX() + "\n");
    		append("ImageableY " + pageFormat.getImageableY() + "\n");
    		append("Width" + pageFormat.getWidth() + "\n");
    		append("Paper " + pageFormat.getPaper() + "\n");
    	}
    }
    private class PrinterAttributeView extends TextArea
    {
    	PrinterAttributeView()
    	{
    		setEditable(false);
    		append("Printer Attributes\n");

    	}
    }
	static final Font font = new Font( Font.SANS_SERIF, Font.PLAIN, 20 );

	class DemoPage implements Printable
    {
    	static final double STEP = 100.0;
    	private Graphics gc;
		@Override
		public int print(Graphics gc, PageFormat pageFormat, int pageIndex) throws PrinterException
		{
			this.gc = gc;
			liney = 90;
			if( pageIndex == 0)
			{
				gc.setFont(font);
	    		gc.fillRect(400, 150, 10, 10);
	    		gc.setXORMode( Color.GREEN);
	    		gc.fillRect(300, 300, 20, 10);
	    		gc.drawString( "Hallo auf Seite " + pageIndex, 100, 100 );
				return Printable.PAGE_EXISTS;
			
			}
			else if( pageIndex == 1)
			{
	    		nextString( "Hallo auf Seite " + pageIndex );
	    		nextString( "pageFormat.getHeight(): " + pageFormat.getHeight() );
	    		nextString( "pageFormat.getWidth(): " + pageFormat.getWidth() );
	    		nextString( "pageFormat.getImageableX(): " + pageFormat.getImageableX() );
	    		nextString( "pageFormat.getImageableY(): " + pageFormat.getImageableY() );
	    		nextString( "pageFormat.getImageableWidth(): " + pageFormat.getImageableWidth() );
	    		nextString( "pageFormat.getImageableHeight(): " + pageFormat.getImageableHeight() );
	    		nextString( "gc.getClip().getBounds().x : " + gc.getClip().getBounds().x);
	    		nextString( "gc.getClip().getBounds().y : " + gc.getClip().getBounds().y);
	    		nextString( "gc.getClip().getBounds().width : " + gc.getClip().getBounds().width);
	    		nextString( "gc.getClip().getBounds().height : " + gc.getClip().getBounds().height);
	    		nextString( "pageFormat.getPaper().getHeight(): " + pageFormat.getPaper().getHeight() );
	    		nextString( "pageFormat.getPaper().getWidth(): " + pageFormat.getPaper().getWidth() );
	    		for( int i = 0; i < 6 ; i++)
	    		{
		    		nextString( "pageFormat.getMatrix()[x]: " + pageFormat.getMatrix()[i] );
	    		}
				return Printable.PAGE_EXISTS;
			}
			else
			{
				return Printable.NO_SUCH_PAGE;
			}
		}
		private int liney;
		private void nextString(String s)
		{
			liney += 20;
			gc.drawString(s, 100, liney);
		}
    }
    public static void main(String[] args)
    {
    	new TestStageAwt();
    }
}
