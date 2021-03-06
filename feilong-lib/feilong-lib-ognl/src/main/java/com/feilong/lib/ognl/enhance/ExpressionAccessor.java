/**
 * 
 */
package com.feilong.lib.ognl.enhance;

import com.feilong.lib.ognl.Node;
import com.feilong.lib.ognl.OgnlContext;

/**
 * Provides pure java expression paths to get/set values from an ognl expression. This
 * is achieved by taking an existing {@link Node} parsed expression and using bytecode
 * enhancements to do the same work using pure java vs the ognl interpreter.
 */
public interface ExpressionAccessor{

    /**
     * Gets the value represented by this expression path, if any.
     * 
     * @param context
     *            The standard ognl context used for variable substitution/etc.
     * @param target
     *            The root object this expression is meant for.
     * @return
     *         The evaluated value, if any.
     */
    Object get(OgnlContext context,Object target);

    /**
     * Sets the value represented by this expression path, if possible.
     * 
     * @param context
     *            The standard ognl context used for variable substitution/etc.
     * @param target
     *            The root object this expression is meant for.
     * @param value
     *            The new value to set if this expression references a settable property.
     */
    void set(OgnlContext context,Object target,Object value);
}
