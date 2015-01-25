package com.otis.marketing.security.authentication.exception;

/* Copyright 2004, 2005, 2006 Acegi Technology Pty Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import org.springframework.security.core.AuthenticationException;

/**
 * Thrown if an authentication request is rejected because the credentials are
 * invalid. For this exception to be thrown, it means the account is neither
 * locked nor disabled.
 *
 * @author Ben Alex
 */
public class UsernameOrPasswordIsNull extends AuthenticationException {

	private static final long serialVersionUID = 1536643149341674788L;

	// ~ Constructors
	// ===================================================================================================

	/**
	 * Constructs a <code>BadCredentialsException</code> with the specified
	 * message.
	 *
	 * @param msg
	 *            the detail message
	 */
	public UsernameOrPasswordIsNull(String msg) {
		super(msg);
	}

	/**
	 * Constructs a <code>BadCredentialsException</code> with the specified
	 * message and root cause.
	 *
	 * @param msg
	 *            the detail message
	 * @param t
	 *            root cause
	 */
	public UsernameOrPasswordIsNull(String msg, Throwable t) {
		super(msg, t);
	}
}