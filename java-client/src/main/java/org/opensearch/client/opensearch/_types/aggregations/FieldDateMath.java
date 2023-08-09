/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * The OpenSearch Contributors require contributions made to
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 */

/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/*
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 */

package org.opensearch.client.opensearch._types.aggregations;

import org.opensearch.client.json.JsonpDeserializable;
import org.opensearch.client.json.JsonpDeserializer;
import org.opensearch.client.json.JsonpMapper;
import org.opensearch.client.json.JsonpSerializable;
import org.opensearch.client.json.UnionDeserializer;
import org.opensearch.client.util.ApiTypeHelper;
import org.opensearch.client.util.ObjectBuilder;
import org.opensearch.client.util.ObjectBuilderBase;
import org.opensearch.client.util.TaggedUnion;
import org.opensearch.client.util.TaggedUnionUtils;
import jakarta.json.stream.JsonGenerator;
import java.util.function.Function;

// typedef: _types.aggregations.FieldDateMath

/**
 * A date range limit, represented either as a DateMath expression or a number
 * expressed according to the target field's precision.
 * 
 */
@JsonpDeserializable
public class FieldDateMath implements TaggedUnion<FieldDateMath.Kind, Object>, JsonpSerializable {

	public enum Kind {
		Expr, Value

	}

	private final Kind _kind;
	private final Object _value;

	@Override
	public final Kind _kind() {
		return _kind;
	}

	@Override
	public final Object _get() {
		return _value;
	}

	private FieldDateMath(Kind kind, Object value) {
		this._kind = kind;
		this._value = value;
	}

	public String _toJsonString() {
		switch (_kind) {
			case Expr :
				return this.expr();
			case Value :
				return String.valueOf(this.value());

			default :
				throw new IllegalStateException("Unknown kind " + _kind);
		}
	}

	private FieldDateMath(Builder builder) {

		this._kind = ApiTypeHelper.requireNonNull(builder._kind, builder, "<variant kind>");
		this._value = ApiTypeHelper.requireNonNull(builder._value, builder, "<variant value>");

	}

	public static FieldDateMath of(Function<Builder, ObjectBuilder<FieldDateMath>> fn) {
		return fn.apply(new Builder()).build();
	}

	/**
	 * Is this variant instance of kind {@code expr}?
	 */
	public boolean isExpr() {
		return _kind == Kind.Expr;
	}

	/**
	 * Get the {@code expr} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code expr} kind.
	 */
	public String expr() {
		return TaggedUnionUtils.get(this, Kind.Expr);
	}

	/**
	 * Is this variant instance of kind {@code value}?
	 */
	public boolean isValue() {
		return _kind == Kind.Value;
	}

	/**
	 * Get the {@code value} variant value.
	 *
	 * @throws IllegalStateException
	 *             if the current variant is not of the {@code value} kind.
	 */
	public Double value() {
		return TaggedUnionUtils.get(this, Kind.Value);
	}

	@Override
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		if (_value instanceof JsonpSerializable) {
			((JsonpSerializable) _value).serialize(generator, mapper);
		} else {
			switch (_kind) {
				case Expr :
					generator.write(((String) this._value));

					break;
				case Value :
					generator.write(((Double) this._value));

					break;
			}
		}

	}

	public static class Builder extends ObjectBuilderBase implements ObjectBuilder<FieldDateMath> {
		private Kind _kind;
		private Object _value;

		public ObjectBuilder<FieldDateMath> expr(String v) {
			this._kind = Kind.Expr;
			this._value = v;
			return this;
		}

		public ObjectBuilder<FieldDateMath> value(Double v) {
			this._kind = Kind.Value;
			this._value = v;
			return this;
		}

		public FieldDateMath build() {
			_checkSingleUse();
			return new FieldDateMath(this);
		}

	}

	private static JsonpDeserializer<FieldDateMath> buildFieldDateMathDeserializer() {
		return new UnionDeserializer.Builder<FieldDateMath, Kind, Object>(FieldDateMath::new, false)
				.addMember(Kind.Expr, JsonpDeserializer.stringDeserializer())
				.addMember(Kind.Value, JsonpDeserializer.doubleDeserializer()).build();
	}

	public static final JsonpDeserializer<FieldDateMath> _DESERIALIZER = JsonpDeserializer
			.lazy(FieldDateMath::buildFieldDateMathDeserializer);
}
