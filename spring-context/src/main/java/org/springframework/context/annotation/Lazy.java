/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.context.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标识是否要延迟初始化bean
 *
 * <p>
 * 可以用于{@link org.springframework.stereotype.Component @Component}直接或间接注释的任何类，
 * 或用{@link Bean @Bean}注释的方法。
 * <p/>
 * 如果在{@code @Component}或{@code @Bean}定义中不存在此注释，则会进行急切eager初始化。
 * 如果存在并设置为{@code true}，则{@code @Bean}或 {@code @Component}不会被初始化，
 * 直到被另一个bean引用
 * 或从封闭的{@link org.springframework.beans.factory.BeanFactory BeanFactory}中显式检索到。
 * 如果存在并设置为{@code false}，则将在启动时由执行单例初始化的bean工厂实例化bean。
 * <p/>
 * 如果在{@link Configuration @Configuration}类上存在Lazy，
 * 则标识应延迟初始化该{@code @Configuration} 中的所有{@code @Bean}方法。
 * 如果{@code @Configuration}类存在{@code @Lazy}注解，
 * 但{@code @Bean}方法上存在{@code @Lazy}并为false，
 * 则表示覆盖了“lazy”行为，并且应该急切地初始化bean。
 * <p/>
 * 除了用于组件初始化的角色外，
 * 还可以将该注释放置在标记为
 * {@link org.springframework.beans.factory.annotation.autowired}
 * 或{@link javax.inject.inject}的注入点上：
 * 在这种情况下，它会为所有受影响的依赖项创建一个惰性解析代理，
 * 以替代使用{{link org.springframework.beans.factory.objectfactory}
 * 或{@link javax.inject.provider}。
 * <p/>
 * Indicates whether a bean is to be lazily initialized.
 *
 * <p>May be used on any class directly or indirectly annotated with {@link
 * org.springframework.stereotype.Component @Component} or on methods annotated with
 * {@link Bean @Bean}.
 *
 * <p>If this annotation is not present on a {@code @Component} or {@code @Bean} definition,
 * eager initialization will occur. If present and set to {@code true}, the {@code @Bean} or
 * {@code @Component} will not be initialized until referenced by another bean or explicitly
 * retrieved from the enclosing {@link org.springframework.beans.factory.BeanFactory
 * BeanFactory}. If present and set to {@code false}, the bean will be instantiated on
 * startup by bean factories that perform eager initialization of singletons.
 *
 * <p>If Lazy is present on a {@link Configuration @Configuration} class, this
 * indicates that all {@code @Bean} methods within that {@code @Configuration}
 * should be lazily initialized. If {@code @Lazy} is present and false on a {@code @Bean}
 * method within a {@code @Lazy}-annotated {@code @Configuration} class, this indicates
 * overriding the 'default lazy' behavior and that the bean should be eagerly initialized.
 *
 * <p>in addition to its role for component initialization, this annotation may also be placed
 * on injection points marked with {@link org.springframework.beans.factory.annotation.autowired}
 * or {@link javax.inject.inject}: in that context, it leads to the creation of a
 * lazy-resolution proxy for all affected dependencies, as an alternative to using
 * {@link org.springframework.beans.factory.objectfactory} or {@link javax.inject.provider}.
 *
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.0
 * @see Primary
 * @see Bean
 * @see Configuration
 * @see org.springframework.stereotype.Component
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Lazy {

	/**
	 * Whether lazy initialization should occur.
	 */
	boolean value() default true;

}
