<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
	<catalog>
	<xsl:for-each select="Products/products">
	<product>
	<id><xsl:value-of select="id"/></id>
	<name><xsl:value-of select="name"/></name>
	<category><xsl:value-of select="category/category"/></category>
	<warehouse><xsl:value-of select="address/cname"/></warehouse>
	<quantity><xsl:value-of select="quantity"/></quantity>
	<price><xsl:value-of select="price"/></price>
	</product>
	</xsl:for-each>
	</catalog>
	
	
	</xsl:template>
</xsl:stylesheet>