
(ns time.core
    #?(:clj (:require [clj-time.core])))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; clj-time.core
#?(:clj  (def days  clj-time.core/days))
#?(:clj  (def minus clj-time.core/minus))
#?(:clj  (def plus  clj-time.core/plus))
#?(:cljs (def days  nil))
#?(:cljs (def minus nil))
#?(:cljs (def plus  nil))
