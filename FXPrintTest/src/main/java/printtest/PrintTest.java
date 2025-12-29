package printtest;



import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.Attribute;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintJobAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class PrintTest extends JFrame
{
	public PrintTest()
	{
		Container c = getContentPane();
		c.setLayout( new GridBagLayout());
		setTitle("Swing Print Test");
		c.add( new RootNode());
		pack();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	private class RootNode extends JPanel
	{
		RootNode()
		{
			add( new Label( PrintServiceLookup.lookupDefaultPrintService().getName() ));

			JButton print = new JButton("print");
			add( print);
			print.addActionListener( PrintTest.this::print);

			JButton pss = new JButton("Page Setup");
			add( pss);
			pss.addActionListener(PrintTest.this::showPageSetup);

			{
				JButton b = new JButton("Print Dialog");
				add( b);
				b.addActionListener( PrintTest.this::showPrintDialog);
				
			}
			add( new PageLayoutView());
			add( new PrinterAttributeView());
		}
	}
//    private void print_old1(final ActionEvent event) {
//    	PrinterJob printerJob = PrinterJob.createPrinterJob();
//    	if( printerJob != null)
//    	{
//    		PageLayout pageLayout = Printer.getDefaultPrinter().getDefaultPageLayout();
//    		PrinterAttributes printerAttributes = Printer.getDefaultPrinter().getPrinterAttributes();
//    		int totalHeight = (int)(pageLayout.getTopMargin() + pageLayout.getPrintableHeight()+ pageLayout.getBottomMargin()) 
//    				* printerAttributes.getDefaultPrintResolution().getFeedResolution();
//    		totalHeight /=72;
//
//    		int totalWidth = (int)(pageLayout.getLeftMargin() + pageLayout.getPrintableWidth()+ pageLayout.getRightMargin())
//    				* printerAttributes.getDefaultPrintResolution().getCrossFeedResolution();
//    		totalWidth /=72;
//
//    		System.out.println("STAT : "  + printerJob.getJobStatus() );
//    		boolean done = printerJob.printPage( new DemoPage(totalWidth/2, totalHeight/2) );
//    		System.out.println("STAT : "  + printerJob.getJobStatus() );
//	    	if( done ) 
//	    	{
//	    		printerJob.endJob();
//	    		System.out.println("Well Done");
//	    	}
//	    	else
//	    		System.out.println("BAH");
//    	}
//    }
    private void print(final ActionEvent event) 
    {
		PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
		DocPrintJob j = printService.createPrintJob();
		try
		{
			j.print(null, null);
		} catch (PrintException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//    	if( printerJob != null)
//    	{
//    		Printer printer = Printer.getDefaultPrinter();
//    		PageLayout pageLayout = printer.getDefaultPageLayout();
//    		PageLayout maxPageLayout = printer.createPageLayout(pageLayout.getPaper(),PageOrientation.PORTRAIT, Printer.MarginType.HARDWARE_MINIMUM);
//    		PrinterAttributes printerAttributes = Printer.getDefaultPrinter().getPrinterAttributes();
//    		PrintResolution resolution = printerAttributes.getDefaultPrintResolution();
//    		int totalHeight = (int)maxPageLayout.getPrintableHeight()*resolution.getFeedResolution();
//    		totalHeight /=72;
//    		totalHeight /= 2;
//
//    		int totalWidth = (int)maxPageLayout.getPrintableWidth() * resolution.getCrossFeedResolution();
//    		totalWidth /=72;
//    		totalWidth /=2;
//    		
//    		System.out.println("STAT : "  + printerJob.getJobStatus() );
//    		DemoPage dp = new DemoPage(totalWidth, totalHeight);
//    		System.out.println("Canvas : " + dp.getWidth() + " X " + dp.getHeight());
//
//    		StackPane sp = new StackPane( dp );
//    		
//    		boolean done = printerJob.printPage( maxPageLayout, sp );
//    		System.out.println("STAT : "  + printerJob.getJobStatus() );
//	    	if( done ) 
//	    	{
//	    		System.out.println("Well Done");
//	    		printerJob.endJob();
//	    	}
//	    	else
//	    		System.out.println("BAH");
//    	}
    }
    private void showPageSetup(final ActionEvent event) {
    	PrinterJob.getPrinterJob().pageDialog( new HashPrintRequestAttributeSet() );
    }
    private void showPrintDialog(final ActionEvent event) {
    	PrinterJob.getPrinterJob().printDialog();
    }
    private class PageLayoutView extends JTextArea
    {
    	PageLayoutView()
    	{
    		setEditable(false);
    		append("PageLayout\n");
    		PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
    		DocPrintJob j = printService.createPrintJob();
    		PrintJobAttributeSet as = j.getAttributes();
    		
    		append("as.length. " + as.size());
    		
    		for( Attribute a : as.toArray())
    		{
    			append("Category: " + a.getCategory().getName() + " Name: " + a.getName() + "\n");
    		}
    	}
    }
    private class PrinterAttributeView extends JTextArea
    {
    	PrinterAttributeView()
    	{
    		setEditable(false);
    		append("Printer Attributes\n");
    		
    		PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
    		PrintServiceAttributeSet psas = printService.getAttributes();
    		append("---PrintServiceAttributeSet---\n");
    		for( Attribute a : psas.toArray())
    		{
    			append("Category: " + a.getCategory().getName() + " Name: " + a.getName() + "\n");
    		}
    		append("---DocFlavor---\n");
    		for( DocFlavor d : printService.getSupportedDocFlavors())
    		{
    			append("DocFlavor: " + d.getMediaType() + " RepresentationClass: " + d.getRepresentationClassName() + "    ---     ");
    			append("MediaSubtype: " + d.getMediaSubtype() + " MimeType: " + d.getMimeType() + "\n");
    		}
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
	    		int w = gc.getClip().getBounds().width; 
	    		int h = gc.getClip().getBounds().height;
	    		int l = 0;
	    		//gc.setLineWidth(4.0);
	    		//gc.setStroke( Color.RED);
//	    		gc.setFill( Color.BLUE);
//	    		//gc.beginPath();
//	    		while( l < dh) {
//	    			gc.moveTo(0.0, l);
//	    			gc.lineTo(dw,l);
//	    			l += STEP;
//	    		}
//	    		//gc.fill();
//	    		gc.closePath();
//	    		//gc.fill();
//	    		gc.stroke();
	    		gc.fillRect(400, 150, 10, 10);
	    		gc.setXORMode( Color.GREEN);
//	    		gc.setStroke( Color.GREEN);
//	    		gc.setFill( Color.SPRINGGREEN);
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
    	new PrintTest();
    }
}
