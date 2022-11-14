<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
 <xsl:template match='/'>
   <html><xsl:apply-templates /></html>
 </xsl:template>
 <xsl:template match='ListaContactos'>
    <head><title>Contact List</title></head>
    <body> 
    <h1>Contact List</h1>
    <table border='1'>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Phone</th>
        <th>PC</th>
        <th>BirthDate</th>
        <th>Lease</th>
        <th>Lease Quantity</th>
    </tr>
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