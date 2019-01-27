<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform "version="1.0">
	<xsl:template match="/">
		<html>
			<body>
				<xsl:for-each select="cdliste/cd">
					<br/>
					<b>
						<xsl:value-of select="interpret"/>
					</b>
					<xsl:call-template name="getTitel">
						<xsl:with-param name="id" select="@id"/>
					</xsl:call-template>
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
	<xsl:template name="getTitel">
		<xsl:param name="id"/>
		<xsl:text/>
		<xsl:value-of select="//cd[@id=$id]/titel"/>
	</xsl:template>
</xsl:stylesheet>