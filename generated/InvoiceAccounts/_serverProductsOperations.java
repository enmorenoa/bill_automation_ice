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

public interface _serverProductsOperations
{
    String requestProduct(Product pc, Ice.Current current);

    void requestMenu(Ice.StringHolder menu, Ice.Current current);

    String requestSuggestion(Ice.Current current);

    int getNumProducts(Ice.Current current);

    Product getProduct(int num, Ice.Current current);
}
