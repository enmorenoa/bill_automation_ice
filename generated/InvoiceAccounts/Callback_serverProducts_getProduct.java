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

public abstract class Callback_serverProducts_getProduct
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackArg1<InvoiceAccounts.Product>
{
    public final void _iceCompleted(Ice.AsyncResult result)
    {
        serverProductsPrxHelper._iceI_getProduct_completed(this, result);
    }
}
