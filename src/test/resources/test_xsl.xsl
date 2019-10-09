<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:template match="/">
		<html>

			<head>
				<style type="text/css">
					table.tfmt {
					border: 1px ;
					}

					td.colfmt {
					border: 1px ;
					background-color: white;
					color: black;
					text-align:right;
					}

					th {
					background-color: #2E9AFE;
					color: white;
					}

				</style>
			</head>

			<body>
				<table class="tfmt">
					<tr>
						<th style="width:250px">Product Code:</th>
						<th style="width:350px">Product Name:</th>
						<th style="width:250px">Price:</th>
						<th style="width:250px">Stock:</th>


					</tr>

					<xsl:for-each select="ProductList/Product">

						<tr>
							<td class="colfmt">
								<xsl:value-of select="productId" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="productName" />
							</td>

							<td class="colfmt">
								<xsl:value-of select="price" />
							</td>
							<td class="colfmt">
								<xsl:value-of select="stock" />
							</td>
						</tr>

					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>