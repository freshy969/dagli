// AUTOGENERATED CODE.  DO NOT MODIFY DIRECTLY!  Instead, please modify the util/function/ComposedFunction.ftl file.
// See the README in the module's src/template directory for details.
package com.linkedin.dagli.util.function;

import java.util.Objects;
import com.linkedin.dagli.util.named.Named;


/**
 * A function class implementing {@link LongFunction6.Serializable} that composes
 * {@link LongFunction6} with a {@link Function1}.  The function is only <strong>actually</strong> serializable
 * if its constituent composed functions are serializable, of course.
 */
class LongComposedFunction6<A, B, C, D, E, F, Q> implements LongFunction6.Serializable<A, B, C, D, E, F>, Named {
  private static final long serialVersionUID = 1;

  private final Function6<A, B, C, D, E, F, Q> _first;
  private final LongFunction1<? super Q> _andThen;

  /**
   * Creates a new instance that composes two functions, i.e. {@code andThen(first(inputs))}.
   *
   * @param first the first function to be called in the composition
   * @param andThen the second function to be called in the composition, accepting the {@code first} functions result
   *                as input
   */
  LongComposedFunction6(Function6<A, B, C, D, E, F, Q> first, LongFunction1<? super Q> andThen) {
    _first = first;
    _andThen = andThen;
  }

  @Override
  @SuppressWarnings("unchecked")
  public LongComposedFunction6<A, B, C, D, E, F, Q> safelySerializable() {
    return new LongComposedFunction6<>(((Function6.Serializable<A, B, C, D, E, F, Q>) _first).safelySerializable(),
        ((LongFunction1.Serializable<? super Q>) _andThen).safelySerializable());
  }

  @Override
  public long apply(A value1, B value2, C value3, D value4, E value5, F value6) {
    return _andThen.apply(_first.apply(value1, value2, value3, value4, value5, value6));
  }

  @Override
  public int hashCode() {
    return Objects.hash(LongComposedFunction6.class, _first, _andThen);
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof LongComposedFunction6) {
      return this._first.equals(((LongComposedFunction6) obj)._first)
          && this._andThen.equals(((LongComposedFunction6) obj)._andThen);
    }
    return false;
  }

  @Override
  public String toString() {
    return Named.getShortName(_andThen) + "(" + Named.getShortName(_first) + ")";
  }

  @Override
  public String getShortName() {
    return Named.getShortName(_andThen) + "(...)";
  }
}
