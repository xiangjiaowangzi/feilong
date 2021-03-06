/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.feilong.net.mail.exception;

import com.feilong.core.DefaultRuntimeException;

/**
 * 通用的邮件相关异常.
 *
 * @author <a href="https://github.com/ifeilong/feilong">feilong</a>
 * @since 1.8.2
 */
public class MailException extends DefaultRuntimeException{

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1699987643831455524L;

    //---------------------------------------------------------------

    /**
     * Instantiates a new mail exception.
     *
     * @param message
     *            the message
     * @param cause
     *            the cause
     */
    public MailException(String message, Throwable cause){
        super(message, cause);
    }

    /**
     * Instantiates a new mail exception.
     *
     * @param cause
     *            the cause
     */
    public MailException(Throwable cause){
        super(cause);
    }
}
