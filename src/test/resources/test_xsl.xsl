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
						float: left;
						width: 100px;
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
						<td class="colfmt">
							Meno:
						</td>
						<td class="colfmt">
							<xsl:value-of select="Registration/name" />
						</td>
					</tr>
					<tr>
						<td class="colfmt">
							Priezvisko:
						</td>
						<td class="colfmt">
							<xsl:value-of select="Registration/surname" />
						</td>
					</tr>
					<tr>
						<td class="colfmt">
							Vek:
						</td>
						<td class="colfmt">
							<xsl:value-of select="Registration/@age" />
						</td>
					</tr>
					<tr>
						<td class="colfmt">
							Dátum kurzu:
						</td>
					</tr>
					<xsl:for-each select="Registration/courseDate">

						<tr>

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