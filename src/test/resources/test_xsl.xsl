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
<!--					<tr>-->
<!--						<th style="width:250px">Product Code:</th>-->
<!--						<th style="width:350px">Product Name:</th>-->
<!--						<th style="width:250px">Price:</th>-->
<!--						<th style="width:250px">Stock:</th>-->
<!--					</tr>-->

					<tr>
						<td class="colfmt">
							Meno:
						</td>
						<td class="colfmt">
							<xsl:value-of select="name" />
						</td>
					</tr>
					<tr>
						<td class="colfmt">
							Priezvisko:
						</td>
						<td class="colfmt">
							<xsl:value-of select="surname" />
						</td>
					</tr>
					<tr>
						<td class="colfmt">
							Vek:
						</td>
						<td class="colfmt">
							<xsl:value-of select="age" />
						</td>
					</tr>
					<xsl:for-each select="courseDate">
						<tr>
							<td class="colfmt">
								Dátumy kurzu:
							</td>
							<td class="colfmt">
								<xsl:value-of select="." />
							</td>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>