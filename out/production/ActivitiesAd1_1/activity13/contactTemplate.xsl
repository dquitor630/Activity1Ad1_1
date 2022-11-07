<?xml version="1.0" encoding='ISO-8859-1'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='ListaContactos'>
    <head><title>Contact List</title></head>
    <body> 
    <h1>Contact List</h1>
    <table border='1'>
    <tr><th>Name</th><th>Address</th></tr><th>Phone</th></tr><th>PC</th></tr><th>BirthDate</th></tr><th>Lease</th></tr></tr><th>Lease Quantity</th></tr>
      <xsl:apply-templates select='DatosContacto' />
    </table>
    </body>
 </xsl:template>
 <xsl:template match='DatosContacto'>
   <tr><xsl:apply-templates /></tr>
 </xsl:template>
 <xsl:template match='contactName|address|phone|postalCode|birthDate|lease|leaseQuantity'>
   <td><xsl:apply-templates /></td>
 </xsl:template>
</xsl:stylesheet>