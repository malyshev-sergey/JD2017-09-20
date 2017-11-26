<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html"/>
    <xsl:template match="/payment">
        <div id="payment">
            <xsl:apply-templates/>
        </div>
    </xsl:template>
    <xsl:template match="/payment/payer">
        <div id="payer">
            <xsl:apply-templates/>
        </div>
    </xsl:template>
    <xsl:template match="/payment/payer/name">
        <h1>
            <xsl:apply-templates/>
        </h1>
    </xsl:template>
    <xsl:template match="/payment/payer/email">
        <h3>
            <xsl:apply-templates/>
        </h3>
    </xsl:template>
    <xsl:template match="/payment/order">
        <div id="order">
            <xsl:apply-templates/>
        </div>
    </xsl:template>
    <xsl:template match="/payment/order/date">
        <div id="date">
            Date: <xsl:apply-templates/>
        </div>
    </xsl:template>
    <xsl:template match="/payment/order/shippingPrice">
        <div id="shippingPrice">
            Shipping price: <xsl:apply-templates/>
        </div>
    </xsl:template>

    <xsl:template match="/payment/order/products">
        <table id="products" border="1">
            <tr><td>Name</td><td>Price</td></tr>
            <xsl:apply-templates/>
        </table>
    </xsl:template>
    <xsl:template match="/payment/order/products/product">
        <tr><xsl:apply-templates/></tr>
    </xsl:template>
    <xsl:template match="/payment/order/products/product/productName">
        <td><xsl:apply-templates/></td>
    </xsl:template>
    <xsl:template match="/payment/order/products/product/price">
        <td><xsl:apply-templates/></td>
    </xsl:template>
</xsl:stylesheet>