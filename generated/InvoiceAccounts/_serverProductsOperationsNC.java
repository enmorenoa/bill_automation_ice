//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.8
//
// <auto-generated>
//
// Generated from file `echaCuentasV2.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package InvoiceAccounts;

public interface _serverProductsOperationsNC
{
    String requestProduct(Product pc);

    void requestMenu(Ice.StringHolder menu);

    String requestSuggestion();

    int getNumProducts();

    Product getProduct(int num);
}