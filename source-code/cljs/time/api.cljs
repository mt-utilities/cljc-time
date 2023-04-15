
(ns time.api
    (:require [time.converters :as converters]
              [time.current    :as current]
              [time.epoch      :as epoch]
              [time.loop       :as loop]
              [time.now        :as now]
              [time.schedule   :as schedule]
              [time.timestamp  :as timestamp]))

;; ----------------------------------------------------------------------------
;; ----------------------------------------------------------------------------

; time.converters
(def ms->s    converters/ms->s)
(def ms->m    converters/ms->m)
(def ms->h    converters/ms->h)
(def ms->D    converters/ms->D)
(def ms->W    converters/ms->W)
(def s->ms    converters/s->ms)
(def s->m     converters/s->m)
(def s->h     converters/s->h)
(def s->D     converters/s->D)
(def s->W     converters/s->W)
(def m->ms    converters/m->ms)
(def m->s     converters/m->s)
(def m->h     converters/m->h)
(def m->D     converters/m->D)
(def m->W     converters/m->W)
(def h->ms    converters/h->ms)
(def h->s     converters/h->s)
(def h->m     converters/h->m)
(def h->D     converters/h->D)
(def h->W     converters/h->W)
(def ms->time converters/ms->time)

; time.current
(def get-year                               current/get-year)
(def get-month                              current/get-month)
(def get-day                                current/get-day)
(def get-date                               current/get-date)
(def get-hours                              current/get-hours)
(def get-hours-left-from-this-day           current/get-hours-left-from-this-day)
(def get-minutes                            current/get-minutes)
(def get-minutes-left-from-this-hour        current/get-minutes-left-from-this-hour)
(def get-seconds                            current/get-seconds)
(def get-seconds-left-from-this-minute      current/get-seconds-left-from-this-minute)
(def get-milliseconds                       current/get-milliseconds)
(def get-milliseconds-left-from-this-second current/get-milliseconds-left-from-this-second)
(def get-milliseconds-left-from-this-minute current/get-milliseconds-left-from-this-minute)

; time.epoch
(def epoch-ms                   epoch/epoch-ms)
(def epoch-s                    epoch/epoch-s)
(def epoch-ms->timestamp-string epoch/epoch-ms->timestamp-string)
(def epoch-s->timestamp-string  epoch/epoch-s->timestamp-string)
(def timestamp-string->epoch-ms epoch/timestamp-string->epoch-ms)
(def timestamp-string->epoch-s  epoch/timestamp-string->epoch-s)

; time.loop
(def reduce-interval loop/reduce-interval)

; time.now
(def elapsed now/elapsed)

; time.schedule
(def set-timeout!    schedule/set-timeout!)
(def set-interval!   schedule/set-interval!)
(def clear-interval! schedule/clear-interval!)

; time.timestamp
(def timestamp-object               timestamp/timestamp-object)
(def timestamp-string               timestamp/timestamp-string)
(def timestamp-string?              timestamp/timestamp-string?)
(def timestamp-object?              timestamp/timestamp-object?)
(def date-string?                   timestamp/date-string?)
(def timestamp-string->year         timestamp/timestamp-string->year)
(def timestamp-object->year         timestamp/timestamp-object->year)
(def timestamp-string->month        timestamp/timestamp-string->month)
(def timestamp-object->month        timestamp/timestamp-object->month)
(def timestamp-string->day          timestamp/timestamp-string->day)
(def timestamp-object->day          timestamp/timestamp-object->day)
(def timestamp-string->hours        timestamp/timestamp-string->hours)
(def timestamp-object->hours        timestamp/timestamp-object->hours)
(def timestamp-string->minutes      timestamp/timestamp-string->minutes)
(def timestamp-object->minutes      timestamp/timestamp-object->minutes)
(def timestamp-string->seconds      timestamp/timestamp-string->seconds)
(def timestamp-object->seconds      timestamp/timestamp-object->seconds)
(def timestamp-string->milliseconds timestamp/timestamp-string->milliseconds)
(def timestamp-object->milliseconds timestamp/timestamp-object->milliseconds)
(def timestamp-string->date         timestamp/timestamp-string->date)
(def timestamp-string->time         timestamp/timestamp-string->time)
(def timestamp-string->date-time    timestamp/timestamp-string->date-time)
(def timestamp-string->today?       timestamp/timestamp-string->today?)
